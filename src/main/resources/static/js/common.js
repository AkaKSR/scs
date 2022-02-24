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