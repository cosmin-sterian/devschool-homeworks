import 'babel-polyfill'
import Cipher from '../scripts/cipher.js'
const { expect } = require("chai");

describe("Cipher without specified key", function() {
    it("should have the default 123 key", function() {
        expect(new Cipher().initialKey).to.be.equal(123);
    });
});

describe("Cipher with not a Number key", function() {
    it("should return a null cipher", function() {
        const fctWrapper = arg => { return function() { new Cipher(arg) } };
        expect(fctWrapper("asd")).to.throw(Error);
        expect(fctWrapper(NaN)).to.throw(Error);
        expect(fctWrapper(null)).to.throw(Error);
    });
});

describe("Cipher encode", function() {
    it("should return proper encoded text of a message", async function() {
        const message = "DevSchool";
        const expected = "1360-2020-2360-1660-1980-2080-2220-2220-2160"
        const cipher = new Cipher(20);
        expect(await cipher.encode(message)).to.be.equal(expected);
    });

    it("should not leave the log list empty after an encode", async function() {
        const message = "DevSchool";
        const expected = "1360-2020-2360-1660-1980-2080-2220-2220-2160"
        const cipher = new Cipher(20);
        expect(await cipher.encode(message)).to.be.equal(expected);
        expect(cipher.readLog()).to.not.be.empty;
    });

    it("should be null if invalid message(not a string type) is passed", async function() {
        const cipher = new Cipher(20);
        expect(await cipher.encode(123)).to.be.null;
    });
});

describe("Cipher decode", function() {
    it("should return proper decoded text of a message", async function() {
        this.timeout(10000); // Increase test timeout because of the 100ms/char timeout
        const message = "1360-2020-2360-1660-1980-2080-2220-2220-2160";
        const expected = "DevSchool";
        const cipher = new Cipher(20);
        expect(await cipher.decode(message)).to.be.equal(expected);
    });

    it("should not leave the log list empty", async function() {
        this.timeout(10000); // Increase test timeout because of the 100ms/char timeout
        const message = "1360-2020-2360-1660-1980-2080-2220-2220-2160";
        const expected = "DevSchool";
        const cipher = new Cipher(20);
        expect(await cipher.decode(message)).to.be.equal(expected);
        expect(cipher.readLog()).to.not.be.empty;
    });
});

describe("Cipher cache", function () {
    it("should cache the message", async function() {
        const message = "DevSchool";
        const expected = "1360-2020-2360-1660-1980-2080-2220-2220-2160"
        const cipher = new Cipher(20);
        await cipher.encode(message);
        expect(cipher.store.get(expected)).to.be.equal(message);
    });
});

describe("Cipher log", function () {
    it("should have 2 logs after 2 operations", async function() {
        this.timeout(10000);
        const message = "DevSchool";
        const expected = "1360-2020-2360-1660-1980-2080-2220-2220-2160"
        const cipher = new Cipher(20);
        expect(await cipher.encode(message)).to.be.equal(expected);
        expect(await cipher.decode(expected)).to.be.equal(message);
        expect(cipher.cipherLog.length).to.be.equal(2);
    });
});