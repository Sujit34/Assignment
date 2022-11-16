const { Console } = require('console');

const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let sum = 0;

const getNumber = ()=>{
    readline.question('What is your number? ', value => {
        
        if( value =='stop')
        {
            console.log(sum);
            return readline.close();            
        } 
        sum = sum + parseInt(value);   
        getNumber();                  
    });     
}

getNumber();