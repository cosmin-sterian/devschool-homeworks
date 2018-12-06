import Cipher from './cipher.js'

const cipherKey = document.querySelector("#cipherKey").textContent;
const decoded = document.querySelector("#decoded").textContent || "DevSchool";
const encoded = document.querySelector("#encoded");
const logContaier = document.querySelector("#logContainer");

let cipher;
let lastKey;

function buttonListener(_) {
    if (cipher == null) {
        if (cipherKey.textContent == null) {
            cipher = new Cipher();
        } else {
            cipher = new Cipher(lastKey);
        }
    }
}