var modal = '';
var attrValue = '';

function showModal(modalNm, attr) {
    console.log("showModal 호출");
    console.log('modalNm = ', modalNm);
    console.log('attr = ', attr);

    modal = modalNm;
    attrValue = attr;
    
    loadModalSrc(modalNm);

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

async function loadModalSrc(modalNm) {
    const api = `/loadsrc?page=${modalNm}`;
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