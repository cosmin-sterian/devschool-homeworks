const gulp = require('gulp');
const del = require('del');
const runSequence = require('run-sequence');

const autoprefixer = require('gulp-autoprefixer');
const csso = require('gulp-csso');
const htmlmin = require('gulp-htmlmin');
const uglify = require('gulp-uglify-es').default;

const gutil = require('gulp-util');

const BROWSERS = [
    'ie >= 10',
    'chrome >= 34',
    'ff >= 30'
];

gulp.task('styles', function() {
    return gulp.src('./styles/styles.css')
        .pipe(autoprefixer({ browsers: BROWSERS }))
        .pipe(csso())
        .pipe(gulp.dest('./build/styles'));
});

gulp.task('scripts', function() {
    return gulp.src('./scripts/*.js')
        .pipe(uglify())
        // .on('error', function (err) { gutil.log(gutil.colors.red('[Error]'), err.toString()); })
        .pipe(gulp.dest('./build/scripts'));
});

gulp.task('resources', function() {
    return gulp.src('./resources/**/*')
        .pipe(gulp.dest('./build/resources'));
});

gulp.task('html', function() {
    return gulp.src('./index.html')
        .pipe(htmlmin({
            collapseWhitespace: true,
            removeComments: true
        }))
        .pipe(gulp.dest('./build'));
});

gulp.task('clean', function() {
    return del(['build']);
});

gulp.task('default', ['clean'], function() { // ruleaza 'clean' inainte de function, tot un fel de chaining
    runSequence(
        'styles',
        'scripts',
        'resources',
        'html'
    );
});