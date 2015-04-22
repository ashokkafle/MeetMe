/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    var pathname = window.location.pathname;
    var pageName = pathname.split("/")[2];
    switch(pageName) {        
        case "about_us.faces":
            $("#homePage").removeClass("current");
            $("#aboutPage").addClass("current");            
            $("#contactPage").removeClass("current");
            $("#profilePage").removeClass("current");            
            break;
        case "contact_us.faces":
            $("#homePage").removeClass("current");
            $("#aboutPage").removeClass("current");            
            $("#contactPage").addClass("current");
            $("#profilePage").removeClass("current");
            break;
        case "profile.faces":
            $("#homePage").removeClass("current");
            $("#aboutPage").removeClass("current");            
            $("#contactPage").removeClass("current");
            $("#profilePage").addClass("current");
        default:
            $("#homePage").addClass("current");
            $("#aboutPage").removeClass("current");            
            $("#contactPage").removeClass("current");
            $("#profilePage").removeClass("current");
    }
});


