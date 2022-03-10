/**
 * @author Harry Kim
 */

// 페이지 이동 이벤트
function moveTo(href) {
    location.href = href;
}

function goBack() {
    history.go(-1);
}

function loadContent(href, fragment, content) {
    location.href = `${href}?fragment=${fragment}&content=${content}`;
}

function vo2Json(data) {
    data = data.split("(")[1];
    data = data.replace(")", "");
    var tmpArr = data.split(", ");
    var tmp = "{";
    var json = "{";

    for (var i = 0; i < tmpArr.length; i++) {
        tmp += "\"" + tmpArr[i].split("=")[0] + "\":\"" + tmpArr[i].split("=")[1] + "\"";

        if (i == (tmpArr.length - 1)) {
            tmp += "}";
        } else {
            tmp += ",";
        }
    }

    json = JSON.parse(tmp);

    return json;
}