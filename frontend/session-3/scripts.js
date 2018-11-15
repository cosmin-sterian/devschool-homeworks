//Task 1
const headerImage = document.getElementById("img1");
const audioElement = document.getElementById("audio1");
var isPlaying = false;

(function(img_arg) {
    img_arg.addEventListener('click', function(_) {
        if (isPlaying) {
            audioElement.pause();
        } else {
            audioElement.play();
        }
    });
})(headerImage);

audioElement.onplaying = function() { isPlaying = true };
audioElement.onpause = function() { isPlaying = false };

//Task 2
function buildThreshholdList() {
    var thresholds = [0];
    var numSteps = 10;

    for(let i=1.0; i <= numSteps; i++) {
        var ratio = i/numSteps; // Btw, what's the difference between let and var?
        thresholds.push(ratio);
    }

    console.log(thresholds);
    return thresholds;
}

const intersectionThreshhold = 0.9;

function handleIntersect(entries, _) {
    entries.forEach(entry => {
        var section = entry.target;
        if (entry.intersectionRatio > intersectionThreshhold) {
            section.classList.add('section-bg-change');
        } else {
            section.classList.remove('section-bg-change');
        }
    })
}

const options = {
    root: null,
    rootMargin: "0px",
    threshold: buildThreshholdList()
};

const observer = new IntersectionObserver(handleIntersect, options);
const sections = document.querySelectorAll('section');
sections.forEach(section => {
    observer.observe(section);
});

// Task 3
const newForm = document.createElement('form');
newForm.action = '';
const btn = document.createElement('button');
const txt = document.createTextNode('psst, hey kid')
btn.appendChild(txt);
newForm.appendChild(btn);
const aside = document.querySelector('aside');
aside.insertBefore(newForm, aside.firstChild);

btn.addEventListener('click', _ => {
    createArticle();
    //TODO: create child button
    aside.removeChild(newForm);
});

function createArticle() {
    const mainElement = document.querySelector('main');
    const newArticle = document.createElement('article');
    newArticle.id = 'a0';
    const newArticleHeader = document.createElement('h2');
    newArticleHeader.textContent = 'This article can pack a section with 400 random characters!';
    newArticle.appendChild(newArticleHeader);
    console.log(mainElement.firstElementChild.nextElementSibling);
    mainElement.insertBefore(newArticle, mainElement.firstElementChild.nextElementSibling);
    /**
     * I did the nextSibling stuff becuase I want to keep the h1 "title" above the new article
     * I think it's more esthetic
     */
    newArticle.tabIndex = -1; // Hack required to make it focusable
    newArticle.focus();
}