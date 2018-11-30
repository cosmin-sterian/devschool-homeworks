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

describe("HTTP Request", function() {
    it("should return city ID when using 'Get Location'", function() {
        forecast = false;
        let xhr = sinon.useFakeXMLHttpRequest();
        let requests = [];
        xhr.onCreate = xhr => { requests.push(xhr); };
        // console.log(xhr);
        formButton.dispatchEvent(new Event("click"));
        // console.log(requests[0]);
        const mockJSON = '[{"title":"Bucharest","location_type":"City","woeid":868274,"latt_long":"44.434200,26.102970"}]';
        requests[0].respond(200, { "Content-Type": "application/json" }, mockJSON);
        // console.log(requests[0]);
        xhr.restore();
        const forecastContainer = document.querySelector('#forecastContainer');
        expect(forecastContainer.textContent).to.be.equal("City ID: 868274");
    });

    it("should return forecast when using 'Get Forecast'", function() {
        forecast = true;
        let xhr = sinon.useFakeXMLHttpRequest();
        let requests = [];
        xhr.onCreate = xhr => { requests.push(xhr); };
        formButton.dispatchEvent(new Event("click"));
        const mockJSON = `{"consolidated_weather":[{"id":5695003066105856,"weather_state_name":"Light Cloud","weather_state_abbr":"lc"}],"title":"London","location_type":"City","woeid":44418,"latt_long":"51.506321,-0.12714","timezone":"Europe/London"}`;
        requests[0].respond(200, { "Content-Type": "application/json" }, mockJSON);
        xhr.restore();
        const forecastContainer = document.querySelector('#forecastContainer');
        expect(forecastContainer.textContent).to.be.equal("Weather: Light Cloud for London");
    });
});