import Cipher from './cipher.js'

const cipherKey = document.querySelector("#cipherKey");
const decoded = document.querySelector("#decoded");
const encoded = document.querySelector("#encoded");
const logContaier = document.querySelector("#logContainer");
const encodeButton = document.querySelector("#encodeButton");
const decodeButton = document.querySelector("#decodeButton");

console.log(encoded);

let cipher;
let lastKey;

console.log(`cipher:${cipher}, cipherKey:${cipherKey.value}, lastKey:${lastKey}`);
console.log(cipherKey.value=="");

encodeButton.addEventListener("click", event => buttonListener(event, true));
decodeButton.addEventListener("click", event => buttonListener(event, false));

async function buttonListener(event, encode) {

    event.preventDefault();
    console.log(cipherKey.value, lastKey);
    console.log(cipherKey);

    if (cipher == undefined) {
        if (cipherKey.value == "") {
            cipher = new Cipher();
        } else {
            cipher = new Cipher(lastKey);
        }
    } else if (cipherKey.value != lastKey) {
        lastKey = cipherKey.value;
        cipher = new Cipher(lastKey);
    }

    if (encode) {
        encoded.value = await cipher.encode(decoded.value || "DevSchool");
    } else {
        decoded.value = await cipher.decode(encoded.value || "1360-2020-2360-1660-1980-2080-2220-2220-2160");
    }

    logContaier.textContent = cipher.readLog();

}