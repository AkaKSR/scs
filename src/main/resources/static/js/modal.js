var modal = '';
var attrValue = '';

function showModal(modalNm, attr) {
    console.log("showModal 호출");
    console.log('modalNm = ', modalNm);
    console.log('attr = ', attr);

    modal = modalNm;
    attrValue = attr;
    
    if (attr != undefined) {
        var json = vo2Json(attr);
        loadModalSrc(modalNm, json.server_idx);
    } else {
        loadModalSrc(modalNm);
    }


    switch (modalNm) {
        case "serverLog":
            $("#modalContents").html("로그 모달");
            break;

        case "settings":
            $("#modalContents").html("설정 모달");
            break;

        case "serverAdd":
            $("#modalContents").html("서버 추가");
            break;
    }

    $('#modalBox').modal('show');
}

function closeModal() {
    $('#modalBox').modal('hide');
}

async function loadModalSrc(modalNm, server_idx) {
    console.log("loadModalSrc 호출");
    var api = `/loadsrc?page=${modalNm}`;
    console.log("server_idx = ", server_idx);

    if (server_idx != undefined) {
        api += `&server_idx=${server_idx}`
    }

    const option = {
        method: "GET"
    };

    const result = await fetch(api, option)
        .then((response) => {
            return response.text();
        })
        .catch((err) => {
            console.error("페이지 로드 실패");
            console.error(err);
            return "";
        });

    $('#modalBody').html(result);
}