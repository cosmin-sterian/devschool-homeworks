class Cipher {
    constructor(initialKey = 123) {
        if (initialKey == null || isNaN(initialKey)) { // Sanity check
            console.error(`Cipher initialKey = '${initialKey}' is not a Number!`);
            return null;
        }
        this.initialKey = initialKey;
        this.cipherLog = [] // List of strings representing the operations logs
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

        encodedList.join // TODO, low battery
    }
}
