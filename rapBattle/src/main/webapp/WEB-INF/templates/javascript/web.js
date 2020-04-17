var constraintObj = {
    audio: {
        echoCancellation: true,
        noiseSuppression: true,
        smapleRate: 44100
    },
    video: true
}

navigator.mediaDevices.getUserMedia(constraintObj)
.then(function(mediaStreamObj) {
    var video = document.querySelector('video');
    if ("srcObject" in video) {
        video.srcObject = mediaStreamObj;
    }

    video.onloadedmetadata = function(ev) {
        video.play();
    };

    var start = document.getElementById('start');
    var stop = document.getElementById('stop');
    var vidSave = document.getElementById('vid2');
    var vid2div = document.getElementById('vid2-div');
    vid2div.style.display = "none";

    var recorder = new MediaRecorder(mediaStreamObj);
    var chunks = [];

    start.addEventListener('click', (ev)=> {
        recorder.start();
        var vid1 = document.getElementById('video1');
        vid2div.style.display = "none";
        vid1.style.display = "inline";
    })

    stop.addEventListener('click', (ev)=> {
        recorder.stop();
        vid2div.style.display = "inline";
        var vid1 = document.getElementById('video1')
        if(vid1.style.display === "none") {
            vid1.style.display = "inline";
        } else {
            vid1.style.display = "none";
        }
    })

    recorder.ondataavailable = function(ev) {
        chunks.push(ev.data);
    }

    recorder.onstop = (ev) => {
        var blob = new Blob(chunks, {'type' : 'video/mp4'});
        chunks = [];
        var videoURL = window.URL.createObjectURL(blob);
        vidSave.src = videoURL;
    }
})
.catch(function(err){
    console.log(err.name, err.message);
});