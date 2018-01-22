    // 兼容性代码
function autoHeight(iframe) {
	console.info(iframe);
    if (iframe) {
      var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
      if (iframeWin.document.body) {
        iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
        iframe.width = iframeWin.document.documentElement.scrollWidth || iframeWin.document.body.scrollWidth;
      }
    }
  }

function changeFrameHeight(ifm){
    //var ifm= document.getElementById("iframeid");
    ifm.height=0;
    ifm.height=document.documentElement.clientHeight+1000;
    console.info(document.documentElement.clientHeight);
}
