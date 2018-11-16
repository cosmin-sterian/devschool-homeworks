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

const intersectionThreshhold = 0.6;

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
const asideDiv = aside.firstElementChild;
asideDiv.insertBefore(newForm, asideDiv.firstChild);

btn.addEventListener('click', _ => {
    asideDiv.removeChild(newForm);
    const newArticle = createArticle();
    const btnAndForm = createButtonInArticle(newArticle);
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
    newArticle.style.wordWrap = 'break-word';
    newArticle.appendChild(newArticleHeader);
    console.log(mainElement.firstElementChild.nextElementSibling);
    mainElement.insertBefore(newArticle, mainElement.firstElementChild.nextElementSibling);
    /**
     * I did the nextSibling stuff becuase I want to keep the h1 "title" above the new article
     * I think it's more esthetic
     */
    window.scrollTo(0, 0); // We want the user to be ready for the surprise element, hue hue

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
    observer.observe(newSection);

    // Create text container
    const newDiv = document.createElement('div');
    newDiv.style.maxWidth = '100%';
    newDiv.style.margin = 'auto';
    newSection.appendChild(newDiv);

    const randomString = createRandomString();
    const newText = document.createTextNode(randomString);
    newDiv.appendChild(newText);
    
    document.querySelector('#img1').src = 'resources/slap.png';
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