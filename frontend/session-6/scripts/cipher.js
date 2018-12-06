import timeout from './timeout.js'

export default class Cipher {
    constructor(initialKey = 123) {
        if (initialKey == null || isNaN(initialKey)) { // Sanity check
            throw new Error(`Cipher initialKey = '${initialKey}' is not a Number!`);
            // return null;
        }
        this.initialKey = initialKey;
        this.cipherLog = [] // List of strings representing the operations logs
        this.store = new Map();
    }

    async encode(message) {
        if (!(typeof message === 'string')) { // Sanity check
            console.error("Please use a string message");
            return null;
        }
        const encodedList = []
        message.split('').forEach(chr => {
            encodedList.push(chr.charCodeAt() * this.initialKey);
        });

        const encoded = encodedList.join("-");
        this.store.set(encoded, message);
        await timeout(message.length * 100);
        this.cipherLog
            .push(`${new Date().toLocaleString()}: "${message}" encoded as "${encoded}"`); // LOG the operation
        return encoded;
    }

    async decode(message) {
        if (!(typeof message === 'string')) { // Sanity check
            console.error("Please use a string message");
            return null;
        }

        let decoded = "";
        if (this.store.has(message)) { // Check if message(encoded) was cached before
            decoded = this.store.get(message);
        } else {
            message.split("-").forEach(encodedChr => {
                decoded += String.fromCharCode(encodedChr / this.initialKey);
            });
        }

        await timeout(message.length * 100);
        this.cipherLog
            .push(`${new Date().toLocaleString()}: "${message}" decoded as "${decoded}"`);
        return decoded;
    }

    readLog() {
        return this.cipherLog.join("\r\n");
    }
}