/*
let myHeading = document.querySelector('h1');
myHeading.textContent = 'Hello world!';
*/

let myImage = document.querySelector('img');

myImage.onclick = function() {
    let mySrc = myImage.getAttribute('src');
    if(mySrc === 'image/firefox-icon.png') {
        myImage.setAttribute('src', 'images/budapest.png');
    } else {
        myImage.setAttribute('src', 'image/firefox-icon.png');
    }
}
