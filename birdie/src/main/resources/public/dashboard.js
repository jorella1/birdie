//fetch("http://localhost:9090/posting/all")

fetch("./tweets.json")
.then(response => {
   return response.json();
})
.then(function(jsondata){
    for(let i = 0; i < jsondata.tweets.length; i++){
        const divTweet = document.createElement('div');
        divTweet.className = 'tweet';
    
        const divRow = document.createElement('div');
        divRow.className = 'row';
        divTweet.appendChild(divRow);
    
        const divCol1 = document.createElement('div');
        divCol1.className = 'col-2 col-xl-1';
        const profilePic = document.createElement('img');
        profilePic.src = jsondata.tweets[i].profileImage;
        profilePic.className = 'img-fluid profile-icon';
        divCol1.appendChild(profilePic);
        divRow.appendChild(divCol1);
    
        const divCol2 = document.createElement('div');
        divCol2.className = 'col-10 col-xl-11';
        const divUsername = document.createElement('div');
        divUsername.innerHTML = '<strong>' + jsondata.tweets[i].username + '</strong>' + '<span>@' + jsondata.tweets[i].handle + '</span>';
        divCol2.appendChild(divUsername);
        const para = document.createElement('p');
        para.innerHTML = jsondata.tweets[i].description;
        divCol2.appendChild(para);

        if(jsondata.tweets[i].media != 'null'){
            const divSrc = document.createElement('div');
            const media = document.createElement('img');
            media.src = jsondata.tweets[i].media;
            media.className = 'img-fluid';
            divSrc.appendChild(media);
            divCol2.appendChild(divSrc);
        }
        const likeButton = document.createElement('input');
        likeButton.type = 'checkbox';
        likeButton.className = 'check_box';
        likeButton.name = 'likeCheckbox';
        const likeLabel = document.createElement('label');
        likeLabel.htmlFor = 'likeButton';
        likeButton.appendChild(likeLabel);
        divCol2.appendChild(likeButton);

        divRow.appendChild(divCol2);


        //document.body.appendChild(elem);
        const tweetCol = document.getElementById('tweetCol');
        tweetCol.appendChild(divTweet);
        const hr = document.createElement('hr');
        tweetCol.appendChild(hr);

        const replyForm = document.createElement('form');
        const replyButton = document.createElement('button');
        replyButton.value = jsondata.tweets[i].id;
        replyButton.type = 'submit';
        replyButton.innerHTML = 'Reply';
        replyButton.formAction = '{postid}'
        replyForm.appendChild(replyButton);
        tweetCol.appendChild(replyForm);
    }
});
