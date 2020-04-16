var player = document.getElementById("video1")
var handleSuccess = function(stream) {
    video1.srcObject = stream;
    console.log("success");
};
navigator.mediaDevices.getUserMedia({video: true, audio: true})
    .then(handleSuccess);