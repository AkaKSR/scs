var contents;

async function loadMenu(cur) {
    var curId = cur.getAttribute("id");
    var el = document.getElementById("panel-title");
    var panel = document.getElementById("panel-body");
    el.textContent = cur.innerText;

    var api = "/panel/serverList";
    var option = {
        method: "GET"
    };

    var replaceHtml = await fetch(api, option)
        .then((response) => {
            console.log(response);
            return response.text();
        })
        .catch((err) => {
            console.error(err);
            return "";
        });

    panel.innerHTML = replaceHtml;

    console.log(curId);
    contents = await loadContents(curId);
    console.log("before = ", contents);
}

async function loadContents(curId) {
    var api = '/api/getServerList';
    var option = {
        method: "POST",
        body: new URLSearchParams({
            curId
        })
    };

    var result = await fetch(api, option)
        .then((response) => {
            return response.json();
        }).catch((err) => {
            console.error("서버 목록 불러오기 실패");
            return "";
        });

    return result;
}

