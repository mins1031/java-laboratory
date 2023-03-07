package java_lab.zipcode;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NewZipCodeResponse {
    private String zipCode;
    private String state;
    private String city;
    private String town;
    private String roadCode;
    private String roadName;
    private String isBaseMent;
    private String buildingMainNum;
    private String buildingSubNum;
    private String buildingManagerNum;
    private String bulkDeliveryName;
    private String cityBuildingName;
    private String legalDongCode;
    private String legalDongName;
    private String villageName;
    private String adminDongName;
    private String isMountain;
    private String parcelMainNum;
    private String parcelSubNum;
    private String moveReasonCode;
    private String beforeUpdateTownCode;
    private String afterUpdateTownCode;
    private String connectionDate;
    private String oldZipCode;
    private String zipCodeSn;

    public NewZipCodeResponse(
            String zipCode,
            String state,
            String city,
            String town,
            String roadCode,
            String roadName,
            String isBaseMent,
            String buildingMainNum,
            String buildingSubNum,
            String buildingManagerNum,
            String bulkDeliveryName,
            String cityBuildingName,
            String legalDongCode,
            String legalDongName,
            String villageName,
            String adminDongName,
            String isMountain,
            String parcelMainNum,
            String parcelSubNum,
            String moveReasonCode,
            String beforeUpdateTownCode,
            String afterUpdateTownCode,
            String connectionDate,
            String oldZipCode,
            String zipCodeSn
    ) {
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.town = town;
        this.roadCode = roadCode;
        this.roadName = roadName;
        this.isBaseMent = isBaseMent;
        this.buildingMainNum = buildingMainNum;
        this.buildingSubNum = buildingSubNum;
        this.buildingManagerNum = buildingManagerNum;
        this.bulkDeliveryName = bulkDeliveryName;
        this.cityBuildingName = cityBuildingName;
        this.legalDongCode = legalDongCode;
        this.legalDongName = legalDongName;
        this.villageName = villageName;
        this.adminDongName = adminDongName;
        this.isMountain = isMountain;
        this.parcelMainNum = parcelMainNum;
        this.parcelSubNum = parcelSubNum;
        this.moveReasonCode = moveReasonCode;
        this.beforeUpdateTownCode = beforeUpdateTownCode;
        this.afterUpdateTownCode = afterUpdateTownCode;
        this.connectionDate = connectionDate;
        this.oldZipCode = oldZipCode;
        this.zipCodeSn = zipCodeSn;
    }

    public static NewZipCodeResponse of(String zipCodeStringLine) {
        int fieldCount = 25;
        List<String> zipCodeDatas = Arrays.stream(zipCodeStringLine.split("[|]")).collect(Collectors.toList());
        int omissionLastTwoColumnCount = 23;
        if (zipCodeDatas.size() != fieldCount && zipCodeDatas.size() == omissionLastTwoColumnCount) {
            zipCodeDatas.add("");
            zipCodeDatas.add("");
        }

        return new NewZipCodeResponse(
                zipCodeDatas.get(0),
                zipCodeDatas.get(1),
                zipCodeDatas.get(2),
                zipCodeDatas.get(3),
                zipCodeDatas.get(4),
                zipCodeDatas.get(5),
                zipCodeDatas.get(6),
                zipCodeDatas.get(7),
                zipCodeDatas.get(8),
                zipCodeDatas.get(9),
                zipCodeDatas.get(10),
                zipCodeDatas.get(11),
                zipCodeDatas.get(12),
                zipCodeDatas.get(13),
                zipCodeDatas.get(14),
                zipCodeDatas.get(15),
                zipCodeDatas.get(16),
                zipCodeDatas.get(17),
                zipCodeDatas.get(18),
                zipCodeDatas.get(19),
                zipCodeDatas.get(20),
                zipCodeDatas.get(21),
                zipCodeDatas.get(22),
                zipCodeDatas.get(23),
                zipCodeDatas.get(24)
        );
    }
}
