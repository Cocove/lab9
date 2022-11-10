<%--
  Created by IntelliJ IDEA.
  User: 19415
  Date: 2022/5/28
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <style>
    body{
      background-image: url("src/img/maxresdefault.jpg");
      background-size:cover;
      background-attachment:fixed;
    }

    .center{
      text-align: center; /*让div内部文字居中*/
      border-radius: 30px;
      width: 300px;
      height: 80px;
      margin: auto;
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      border: 3px solid red;
    }

    select{
      width: 70px;
      height: 20px;
      line-height: 20px;
      padding-left: 10px;
    }
  </style>

  <div class="center">
    <iframe id="myIframe" name="hideIframe" style="display:none;"></iframe>
    <form class="testform" id = "testform" method="post" action="" target="hideIframe">
      <div>
        <input id = "im_form" name="im_form" type="text" placeholder="输入金额" autofocus = "autofocus" required = "required"/>
        <select id ="myform">
          <option value ="USD">USD</option>
          <option value ="BYN">BYN</option>
          <option value="EUR">EUR</option>
          <option value="CNY">CNY</option>
        </select>
      </div>

      <div>
        <input id = "im_to" name="im_to" type="text" placeholder="获得金额" readonly/>
        <select id="myto" >
          <option value ="USD">USD</option>
          <option value ="BYN">BYN</option>
          <option value="EUR">EUR</option>
          <option value="CNY">CNY</option>
        </select>
      </div>

    </form>

    <button class="nowRate" onclick='nowRate()'>提交</button>
    <button class="change" onclick="change()">更改</button>
    <button class="clear" onclick="myclear()">清除</button>


  </div>

  <script>
    var Rate;

    function nowRate() {
      var im_form = document.getElementById("im_form");
      var im_to = document.getElementById("im_to");

      var from = getForm();
      var to = getTo();
      var xmlhttp = new XMLHttpRequest();
      var URL = 'https://v6.exchangerate-api.com/v6/238e764b1a0052b725907364/pair/'+ from+'/'+to;
      var type = "Get";
      xmlhttp.open(type,URL,true);
      xmlhttp.send();
      xmlhttp.onreadystatechange = function () {
        if(xmlhttp.status==200&&xmlhttp.readyState==4){
          var request = JSON.parse(xmlhttp.response);
          Rate =  request.conversion_rate;
          var res_money = im_form.value * Rate;
          if(res_money!=0){
            im_to.value = res_money;
          }else{
            alert("请输入数字")
          }


          return Rate;
        }
      }
    }

    function getForm(){
      var myselectfrom = document.getElementById("myform");
      var fromindex=myselectfrom.selectedIndex;
      var fromvalue = myselectfrom.options[fromindex].value;
      return fromvalue;
    }

    function getTo(){
      var myto = document.getElementById("myto");
      var toindex = myto.selectedIndex;
      var tovalue = myto.options[toindex].value;
      return tovalue;
    }
    function change() {
      var myselectfrom1 = document.getElementById("myform");
      var fromindex1=myselectfrom1.selectedIndex;
      var myto1 = document.getElementById("myto");
      var toindex1 = myto1.selectedIndex;
      myselectfrom1[toindex1].selected = true;
      myto1[fromindex1].selected = true;
      nowRate();
    }
    function myclear() {
      var myselectfrom2 = document.getElementById("myform");
      var myto2 = document.getElementById("myto");
      myselectfrom2[0].selected = true;
      myto2[0].selected = true;
      var im_form = document.getElementById("im_form");
      var im_to = document.getElementById("im_to");
      im_to.value = null;
      im_form.value = null;

    }
  </script>
  </body>
</html>
