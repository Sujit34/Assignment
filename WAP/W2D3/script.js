window.onload = function(){
    let intervalId = null;
    let growthRate =250;
    const Div = document.getElementById("circle");
    const Width = document.getElementById("width");
    const GrowthAmount = document.getElementById("amount");
    const GrowthRate = document.getElementById("rate");
    const circleNumber = document.getElementById("circle-number");
    const startBtn = document.getElementById("start-button");
    Div.onclick = stop;
    startBtn.onclick = growCircleByInput;
    
    function animation(rate){
        if(intervalId == null){
            intervalId = setInterval(function(){
                let height = Div.clientHeight;
                let width = Div.clientWidth;
                Div.style.height = height+10+"px";
                Div.style.width = width+10+"px";
                Div.style.borderRadius = height/2 +"px";
                 
            },rate);
        }
    }
    animation(growthRate);

    function growCircleByInput(){
        Div.style.height = circleGrowthAmount.value+"px";
        Div.style.width = circleWidth.value+"px";
        Div.style.borderRadius = circleWidth.value/2 +"px";
        animation(circleGrowthRate.value);        
    }
    function createCircle(){
        let positionChange = false;
        for(let i =0; i<circleNumber.value;i++){
            let newDiv = document.createElement("div");
            document.getElementById("Div").appendChild(newDiv);
            newDiv.style.height = circleGrowthAmount.value+"px";
            newDiv.style.width = circleWidth.value+"px";
            newDiv.style.borderRadius = circleWidth.value/2 +"px";
            if(!positionChange){
                newDiv.style.left = "5px";
                positionChange = true;
            }else{
                newDiv.style.right = "5px";
                positionChange = false;
            }
            animation(circleGrowthRate.value);
        }
    }

    function stop(){
        clearInterval(intervalId);
        resetCircle();
        intervalId= null;
    }
    function resetCircle(){
        Div.style.height = "0px";
        Div.style.width = "0px";
        Div.style.borderRadius = "0px";
    }
}