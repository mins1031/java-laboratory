package java_lab.reflaction.myjackson;

import com.sun.xml.internal.ws.util.xml.CDATA;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MyJackson {

    public <T> String serialize(T response) throws IllegalAccessException {
        Class<?> responseClass = response.getClass();
        StringBuilder stringBuilder = new StringBuilder("{\n");
        Field[] fields = responseClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            if (type.equals(String.class)) {
                generateStringJsonLine(response, stringBuilder, field);
            }

            if (type.equals(Double.class) || type.equals(double.class)) {
                generateDoubleJsonLine(response, stringBuilder, field);
            }

            if (type.equals(List.class)) {
                ParameterizedType genericType = (ParameterizedType) field.getGenericType();
                Type[] actualTypeArguments = genericType.getActualTypeArguments();
                stringBuilder.append("    ");
                stringBuilder.append("\"" + field.getName() + "\"");
                stringBuilder.append(" : ");
                stringBuilder.append("[ \n");

                if (isStringListGenericType(actualTypeArguments[0])) {
                    Object listDatas = field.get(response);
                    String stringListValues = String.valueOf(listDatas);
                    String replacingValues = stringListValues
                            .replace("[", "")
                            .replace("]", "");
                    String[] split = replacingValues.split(", ");
                    for (String s : split) {
                        generateStringJsonLineInList(stringBuilder, s);
                    }
                }

                if (isDoubleListGenericType(actualTypeArguments[0])) {
                    Object listDatas = field.get(response);
                    String stringListValues = String.valueOf(listDatas);
                    String replacingValues = stringListValues
                            .replace("[", "")
                            .replace("]", "");
                    String[] split = replacingValues.split(", ");
                    for (String s : split) {
                        generateDoubleJsonLineInList(stringBuilder, s);
                    }
                }

                stringBuilder.append("    ");
                stringBuilder.append("], \n");
            }

        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private boolean isStringListGenericType(Type actualTypeArgument) {
        return String.valueOf(actualTypeArgument).contains("String");
    }

    private boolean isDoubleListGenericType(Type actualTypeArgument) {
        return String.valueOf(actualTypeArgument).contains("Double") || String.valueOf(actualTypeArgument).contains("double");
    }

    private <T> void generateStringJsonLine(T response, StringBuilder stringBuilder, Field field) throws IllegalAccessException {
        stringBuilder.append("    ");
        stringBuilder.append("\"" + field.getName() + "\"");
        stringBuilder.append(" : ");
        stringBuilder.append("\"" + field.get(response) + "\"");
        stringBuilder.append("," + "\n");
    }

    private <T> void generateStringJsonLineInList(StringBuilder stringBuilder, String element) throws IllegalAccessException {
        stringBuilder.append("    ");
        stringBuilder.append("    ");
        stringBuilder.append("\"" + element + "\"");
        stringBuilder.append("," + "\n");
    }

    private <T> void generateDoubleJsonLine(T response, StringBuilder stringBuilder, Field field) throws IllegalAccessException {
        stringBuilder.append("    ");
        stringBuilder.append("\"" + field.getName() + "\"");
        stringBuilder.append(" : ");
        stringBuilder.append(field.get(response));
        stringBuilder.append("," + "\n");
    }

    private <T> void generateDoubleJsonLineInList(StringBuilder stringBuilder, String element) {
        stringBuilder.append("    ");
        stringBuilder.append("    ");
        stringBuilder.append(element);
        stringBuilder.append("," + "\n");
    }

    public Object deserialize(String request, Class<?> clazz) throws ReflectiveOperationException {
        Class<?> aClass = Class.forName(clazz.getName());
        Constructor<?> noParamConstructor = aClass.getDeclaredConstructor();
        Object instance = noParamConstructor.newInstance();

        Arrays.stream(clazz.getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            String fieldName = field.getName();
            int fieldNameStartIndex = request.indexOf(fieldName);
            int fieldNameEndIndex = fieldNameStartIndex + fieldName.length() + 3;
            int fieldValueStartIndex = fieldNameEndIndex + 1;
            String substring = request.substring(fieldNameStartIndex, fieldNameEndIndex);

            if (isKeyField(fieldName, substring) && isSingleVariable(request, fieldValueStartIndex)) {
                Pattern pattern = Pattern.compile(substring + "(.*?)(,)");
                Matcher matcher = pattern.matcher(request);
                if (matcher.find()) {
                    String matchValueStringType = matcher.group(1).trim();
                    Double matchValueDoubleType;
                    if (matchValueStringType == null) {
                        throw new RuntimeException();
                    }

                    matchValueDoubleType = checkMatcherTypeIsDouble(matchValueStringType);

                    if (matchValueDoubleType == null) {
                        try {
                            field.set(instance, matchValueStringType);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            field.set(instance, matchValueDoubleType);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                String fieldListValue = request.substring(fieldValueStartIndex);
                boolean isStringValue = false;
                StringBuilder stringBuilder = new StringBuilder();
                char[] chars = fieldListValue.toCharArray();
                for (char aChar : chars) {
                    if (aChar == '[') {
                        continue;
                    }

                    if (aChar == ' ') {
                        continue;
                    }

                    if (aChar == ']') {
                        break;
                    }

                    if (aChar == '\"') {
                        isStringValue = true;
                    }

                    stringBuilder.append(aChar);
                }

                if (isStringValue) {
                    try {
                        List<String> stringListValues = Arrays.stream(stringBuilder.toString().split(","))
                                .map(data -> data.replaceAll("\n", ""))
                                .collect(Collectors.toList());
                        field.set(instance, stringListValues);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    setDoubleListField(instance, field, stringBuilder);
                }
            }

        });

        return instance;
    }

    private void setDoubleListField(Object instance, Field field, StringBuilder stringBuilder) {
        try {
            String[] split = stringBuilder.toString().split(",");
            List<Double> doubleListValues = Arrays.stream(split)
                    .map(data -> data.replaceAll("\n", ""))
                    .filter(data -> (!data.isEmpty() || !data.equals("")))
                    .map(data -> Double.valueOf(data))
                    .collect(Collectors.toList());
            field.set(instance, doubleListValues);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private boolean isKeyField(String fieldName, String substring) {
        String checkSubStringIsKey = " :";
        return substring.equals(fieldName + "\"" + checkSubStringIsKey);
    }

    private boolean isSingleVariable(String request, int fieldValueStartIndex) {
        String fieldValueHeadChar = String.valueOf(request.charAt(fieldValueStartIndex));
        return !fieldValueHeadChar.equals("[");
    }
    private Double checkMatcherTypeIsDouble(String matchValueStringType) {
        Double matchValueDoubleType;
        try {
            matchValueDoubleType = Double.parseDouble(matchValueStringType);
        } catch (NumberFormatException e) {
            matchValueDoubleType = null;
        }
        return matchValueDoubleType;
    }

}
