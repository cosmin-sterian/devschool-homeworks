import 'babel-polyfill'
import Cipher from '../scripts/script.js'
const { expect } = require("chai");
// const chai = require("chai");
// const chaiAsPromised = require("chai-as-promised");
// chai.use(chaiAsPromised);
// const expect = chai.expect;

describe("Cipher without specified key", function() {
    it("should have the default 123 key", function() {
        expect(new Cipher().initialKey).to.be.equal(123);
    });
});

describe("Cipher encode", function() {
    const cipher = new Cipher(20); // Check if bad practice
    it("should return proper encoded text of a message", async function() {
        const message = "DevSchool";
        const expected = "1360-2020-2360-1660-1980-2080-2220-2220-2160"
        // const cipher = new Cipher(20);
        expect(await cipher.encode(message)).to.be.equal(expected);
    });

    it("should not leave the log list empty", function() {
        expect(cipher.readLog()).to.not.be.empty;
    });

    it("should be null if invalid message(not a string type) is passed", async function() {
        expect(await cipher.encode(123)).to.be.null;
    });
});

describe("Cipher decode", function() {
    const cipher = new Cipher(20);
    it("should return proper decoded text of a message", async function() {
        this.timeout(10000); // Increase test timeout because of the 100ms/char timeout
        const message = "1360-2020-2360-1660-1980-2080-2220-2220-2160";
        const expected = "DevSchool";
        expect(await cipher.decode(message)).to.be.equal(expected);
    });

    it("should not leave the log list empty", function() {
        expect(cipher.readLog()).to.not.be.empty;
    });
});