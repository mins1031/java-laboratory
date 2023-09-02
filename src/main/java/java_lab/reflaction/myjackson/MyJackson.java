package java_lab.reflaction.myjackson;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

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

    private <T> void generateDoubleJsonLineInList(StringBuilder stringBuilder, String element) throws IllegalAccessException {
        stringBuilder.append("    ");
        stringBuilder.append("    ");
        stringBuilder.append(element);
        stringBuilder.append("," + "\n");
    }

    public <T> T deserialize(String request) {
        T name = null;
        return name;
    }
}
