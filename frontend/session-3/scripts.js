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
const strSize = 400;
const newForm = document.createElement('form');
newForm.action = '';
const btn = document.createElement('button');
const txt = document.createTextNode('psst, hey kid')
btn.appendChild(txt);
newForm.appendChild(btn);
const aside = document.querySelector('aside');
aside.insertBefore(newForm, aside.firstChild);

btn.addEventListener('click', _ => {
    aside.removeChild(newForm);
    const newArticle = createArticle();
    const btnAndForm = createButtonInArticle(newArticle);
    //TODO: add event listener on new button and create section
    const anotherBtn = btnAndForm.button;
    anotherBtn.addEventListener('click', _ => {
        createSection(btnAndForm.form, newArticle);
    });
});

function createArticle() {
    const mainElement = document.querySelector('main');
    const newArticle = document.createElement('article');
    const newArticleHeader = document.createElement('h2');
    newArticleHeader.textContent = 'This article can pack a section with 400 random characters!';
    newArticleHeader.id = 'a0';
    newArticle.style.textAlign = 'center';
    newArticle.appendChild(newArticleHeader);
    console.log(mainElement.firstElementChild.nextElementSibling);
    mainElement.insertBefore(newArticle, mainElement.firstElementChild.nextElementSibling);
    /**
     * I did the nextSibling stuff becuase I want to keep the h1 "title" above the new article
     * I think it's more esthetic
     */
    newArticle.tabIndex = -1; // Hack required to make it focusable
    newArticle.focus();
    newArticle.removeAttribute('tabIndex'); // Clean up

    return newArticle;
}

function createButtonInArticle(article) {
    const newForm = document.createElement('form');
    newForm.action = "";
    const btn = document.createElement('button');
    const txt = document.createTextNode('*slaps roof of button*');
    btn.appendChild(txt);
    newForm.appendChild(btn);
    article.appendChild(newForm);

    return {button: btn, form: newForm};
}

function createSection(form, article) {
    form.parentElement.removeChild(form);
    const newSection = document.createElement('section');
    const newSectionHeader = document.createElement('h3');
    newSectionHeader.textContent = 'Here are the 400 random characters';
    newSectionHeader.id = 's0';
    newSection.appendChild(newSectionHeader);
    article.appendChild(newSection);
    const randomString = createRandomString();
    const newText = document.createTextNode(randomString);
    newSection.appendChild(newText);
}

function createAlphabetList() {
    var alphabet = [];
    const capitalAIndex = 'A'.charCodeAt(0);
    const capitalZIndex = 'Z'.charCodeAt(0);

    for (i = capitalAIndex; i <= capitalZIndex; i++) {
        alphabet.push(String.fromCharCode(i));
        alphabet.push(String.fromCharCode(i + 32));
    }

    return alphabet;
}

function createRandomString() {
    var randomString = "";
    const alphabet = createAlphabetList();

    for (i = 0; i < strSize; i++) {
        var randomNumber = Math.floor(Math.random() * alphabet.length);
        randomString += alphabet[randomNumber];
    }

    return randomString;
}