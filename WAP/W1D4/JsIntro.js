// 1 - Define a function max() that takes two numbers as arguments and returns the largest of them. 
// Use the if-then-else construct available in Javascript.

function max(x, y){
    if(x>y) return x;
    else return y;
}
console.log("Expected output of max(20,10) is 10 " + myFunctionTest(10, function () { return max(20, 10); }));

// 2 - Define a function maxOfThree() that takes three numbers as arguments and returns the largest of them.

function maxOfThree(x,y,z){
    if(x>=y && x>=z) return x;
    if(y>=x && y>=z) return y;
    if(z>=x && z>=y) return z;
}
console.log("Expected output of maxOfThree(20, 4, 44) is 44 " + myFunctionTest(44, function () { return maxOfThree(20, 4, 44); }));

// 3 - Write a function isVowel() that takes a character (i.e. a string of length 1) 
// and returns true if it is a vowel, false otherwise.

function isVowel(character){    
    const vowel = ["a","e","i","o","u","A","E","I","O","U"];   
    return vowel.find(i=>i==character) ? true : false; 
}
console.log("Expected output of isVowel('a') is true " + myFunctionTest(true, function () { return isVowel('b'); }));

// 4 - Define a function sum() and a function multiply() that sums and multiplies (respectively) 
// all the numbers in an array of numbers. For example, sum([1,2,3,4]) should return 10, 
// and multiply([1,2,3,4]) should return 24.

function sum(arr){
    return arr.reduce((sum,i)=>sum+i,0);
}
console.log("Expected output of sum([1, 2, 3, 4]) is 10 " + myFunctionTest(10, function () { return sum([1, 2, 3, 4]); }));

function multiply(arr){
    return arr.reduce((multiply,i)=>multiply*i,1);
}
console.log("Expected output of sum([1, 2, 3, 4]) is 10 " + myFunctionTest(24, function () { return multiply([1, 2, 3, 4]); }));

// 5 - Define a function reverse() that computes the reversal of a string. 
// For example, reverse("jag testar") should return the string "ratset gaj".

function reverse(str){    
    let reverse = "";
    for(let i = str.length-1; i>=0; i--){        
       reverse = reverse + str.charAt(i);
    }
    return reverse;
}
console.log("Expected output of reverse('Hello World') is dlroW olleH " + myFunctionTest('dlroW olleH', function () { return reverse('Hello World'); }));

// 6 - Write a function findLongestWord() that takes an array of words and returns the 
// length of the longest one.

function findLongestWord(words){
    let max=0;
    for(let i=0; i<words.length; i++){
        if(words[i].length>max) 
            max = words[i].length;
    }
    return max;
}
console.log("Expected output of findLongestWord(['Hello', 'World', 'Md']) is Md " + myFunctionTest('Md', function () { return findLongestWord(['Hello', 'World', 'Md']); }));

// 7 - Write a function filterLongWords() that takes an array of words and 
// an integer i and returns the array of words that are longer than i.

function filterLongWords(words,i){   
    return words.filter(x=>x.length>i);    
}
console.log("Expected output of filterLongWords(['Hello', 'World', 'Md'], 2) is 'Hello,World' " + myFunctionTest(['hello', 'World'], function () { return filterLongWords(['Hello', 'World', 'Md'], 2); }));

// 8 - Modify the jsfiddle on the map/filter/reduce slide ( https://jsfiddle.net/keithlevi/e6kqvx2f/9/ )
// as follows:

// a) multiply each element by 10; 
// b) return array with all elements equal to 3; 
// c) return the product of all elements;

const a = [1,3,5,3,3]; 
const b = a.map(i=>i*10);
document.writeln(b.toString() + "<br/>");

const c = a.filter(i=>i==3);
document.writeln(c.toString() + "<br/>");

const d = a.reduce((product,i)=>product*i,1);
document.writeln(d+ "<br/>");


//Test
function myFunctionTest(output, functionName) {
    let f = functionName();
    if (Array.isArray(f) && Array.isArray(output)) {
        if (arrayEquals(f, output)) {
            return "TEST SUCCEEDED";
        }
    } else if (f === output) {
        return "TEST SUCCEEDED";
    }
    return "TEST FAILED. Expected " + output + " found " + f;
}

function arrayEquals(a, b) {
    return Array.isArray(a) &&
        Array.isArray(b) &&
        a.length === b.length &&
        a.every((val, index) => val === b[index]);
}
    