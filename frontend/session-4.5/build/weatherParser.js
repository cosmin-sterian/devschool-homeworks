let xhr,forecastBoolean;function requestDataFromWeatherAPI(e,t,a){if(e.preventDefault(),xhr=new XMLHttpRequest,forecastBoolean=t,!xhr)return alert("Can't create XMLHTTP instance"),!1;xhr.onreadystatechange=fetchData,t?xhr.open("GET",`https://www.metaweather.com/api/location/${a}`):xhr.open("GET",`https://www.metaweather.com/api/location/search/?query=${a}`),xhr.send()}function fetchData(){if(xhr.readyState===XMLHttpRequest.DONE){const e=document.querySelector("#forecastContainer");if(e.style.display="inline-block",e.textContent="",200===xhr.status){const t=JSON.parse(xhr.responseText);e.textContent=forecastBoolean?"Weather: "+t.consolidated_weather[0].weather_state_name+" for "+t.title:"City ID: "+t[0].woeid}else e.textContent="Content not found"}}