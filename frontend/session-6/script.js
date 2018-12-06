class Cipher {
    constructor(initialKey = 123) {
        if (initialKey == null || isNaN(initialKey)) { // Sanity check
            console.error(`Cipher initialKey = '${initialKey}' is not a Number!`);
            return null;
        }
        this.initialKey = initialKey;
        this.cipherLog = [] // List of strings representing the operations logs
        this.store = new Map();
    }

    encode(message) {
        if (! typeof message === 'string') { // Sanity check
            console.error("Please use a string message");
            return null;
        }
        const encodedList = []
        message.split('').forEach(chr => {
            encodedList.push(chr.charCodeAt() * this.initialKey);
        });

        const encoded = encodedList.join("-");
        this.store.set(encoded, message);
        this.cipherLog
            .push(`${new Date().toLocaleString()}: "${message}" encoded as "${encoded}"`); // LOG the operation
        return encoded;
    }

    decode(message) {
        if (! typeof message === 'string') { // Sanity check
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

        this.cipherLog
            .push(`${new Date().toLocaleString()}: "${message}" decoded as "${decoded}"`);
        return decoded;
    }

    readLog() {
        return this.cipherLog.join("\n");
    }
}

//TODO: Move test to a test script
const cipher = new Cipher(20);
const msg = cipher.encode("DevSchool");
console.log(msg);
console.log(cipher.decode(msg));
console.log(cipher.readLog());