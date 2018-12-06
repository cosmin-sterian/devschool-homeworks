/**
 * TIL: you can't await on a timeout, because it returns
 * a Promise just after the timeout is done, so it must be
 * manuall "promisified", as shown here:
 * https://stackoverflow.com/questions/33289726/combination-of-async-function-await-settimeout
 *
 * But still, why does the Promise self-evaluate? No ".then" called on it
 * As MDN says, "If the value of the expression following the await operator
 * is not a Promise, it's converted to a resolved Promise.", so probably
 * even an unresolved Promise is converted to a resolved one.
 */

export default function timeout(time) {
    return new Promise(resolve => setTimeout(resolve, time));
}