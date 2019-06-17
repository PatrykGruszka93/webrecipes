function loadRecipes(elementId, url) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById(elementId).innerHTML +=
                this.responseText;
        }
    };
    xhttp.open("GET", url, true);
    xhttp.send();
}

function confirmLink(link,message) {
    if(confirm(message)) {
        window.location.href=link;
    }
}