function isEqual(a,b){
    return JSON.stringify(a) == JSON.stringify(b);
}

function Oin(a,b) {   //a在b中
    for(var v of b){
        if(isEqual(a,v)) return true;
    }
    return false;
}
