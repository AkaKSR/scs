var ipAddr = $.get("http://api.ip.pe.kr/json/", function (data) {
    var country = data.country_code;
    var ip = data.ip;

    switch (country) {
        case "KR":
            $("#kr").show();
            break;

        default:
            $("#us").show();
            break;
    }

    document.getElementById("ipAddr").innerText = "ipAddr: " + ip;
});