describe("Button text", function() {
    it("should be 'Get Location' when City ID is empty", function() {
        cityIDInput.value = "";
        cityIDInput.dispatchEvent(new Event("input"));
        expect(formButton.textContent).to.be.equal("Get Location");
    });

    it("should be 'Get Forecast' when City ID is not empty", function() {
        cityIDInput.value = "868274";
        cityIDInput.dispatchEvent(new Event("input"));
        expect(formButton.textContent).to.be.equal("Get Forecast");
    });
});