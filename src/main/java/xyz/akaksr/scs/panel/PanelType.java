package xyz.akaksr.scs.panel;

public class PanelType {

    public static String getPanelData(String content) {
        String result = new String();

        switch (content) {
            case "dashBoard":
                result = "대시보드";
                break;

            case "serverList":
                result = "서버 목록";
                break;

            case "serviceList":
                result = "서비스 목록";
                break;

            default:
                result = "";
                break;
        }

        return result;
    }
}
