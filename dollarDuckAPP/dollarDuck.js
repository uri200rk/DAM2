

// client id  201907890850-2mr51j065r2m1c2id16trkotq7go7pd5.apps.googleusercontent.com 

// api key AIzaSyCPyzW_SVgl6ZDNO09f8Zq3eCNYNZCTC3M 
//key = AIzaSyCPyzW_SVgl6ZDNO09f8Zq3eCNYNZCTC3M
$(function(){
    var url2= "https://sheets.googleapis.com/v4/spreadsheets/1fbqJKI7A-W6G1ubuxS5ScDp-suE3k7y9YoP-LdR5lYg/values/";
	url2 += "oriolDB!A1:B1?majorDimension=ROWS&key=AIzaSyCPyzW_SVgl6ZDNO09f8Zq3eCNYNZCTC3M";

    $.get(url2,function(dades){
        
        console.log(JSON.stringify(dades));
    });
});