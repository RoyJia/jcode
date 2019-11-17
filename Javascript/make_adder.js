/**
 * I'm going to understand this as Factory mode
 * thinking of this plus behavior, I want to create a factory to produce any types plus behavior
 * @param {*} x 
 */
function makeAdder(x) {

    function add(y) {
        return x + y;
    }

    return add;
}

var plusOne = makeAdder(1);
var plusTen = makeAdder(10);

console.log(plusOne(100));
console.log(plusTen(100));