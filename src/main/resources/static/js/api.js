async function login() {
    var id = document.getElementById("id").value;
    var pwd = document.getElementById("pwd").value;

    var api = '/api/login';
    var option = {
        method: "POST",
        body: new URLSearchParams({
            id,
            pwd,
        })
    };

    var result = await fetch(api, option)
        .then((response) => {
            return response.json();
        }).catch((err) => {
            console.error("로그인 실패");
            return "";
        });

    console.log(result);

    if (result == "") {
        location.href = "/";
    } else {
        location.href = `/main?fragment=panel&content=dashBoard`;
    }
}

async function register() {
    var user_id = document.getElementById("user_id").value;
    var user_pwd = document.getElementById("user_pwd").value;
    var user_nm = document.getElementById("user_nm").value;

    var api = '/api/register';
    var option = {
        method: "POST",
        body: new URLSearchParams({
            user_id, user_pwd, user_nm
        })
    };

    var result = await fetch(api, option)
        .then((response) => {
            return response.json();
        }).catch((err) => {
            console.error("회원가입 실패");
            return "";
        });

    if (result == "") {
        alert("회원가입 실패");
    } else {
        location.href = "/";
    }
}

async function getLog(server, id, pass) {
    console.log('getLog 호출');

    var api = '/api/getlog';
    var option = {
        method: "POST",
        body: new URLSearchParams({
            server,
            id,
            pass
        })
    };

    var result = await fetch(api, option)
        .then((response) => {
            return response.text();
        }).catch((err) => {
            console.error("서버 정보 가져오기 실패", err);
            return "";
        });

    return result;
}