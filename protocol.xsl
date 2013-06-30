<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <script>
          function confirm(event, node)
          {
            <!--alert("谢谢!您刚刚敲击了" + event.keyCode + "键");-->
            var key=event.keyCode;
            if (key==49||key==50||key==51||key==52||key==53||key==54||key==55||key==56||key==57|| key==48)
            {
              alert("你刚刚敲击了数字键["+(key-48)+"]!");
              alert(node.innerHTML);
            }
            else if(key==97||key==98||key==99||key==100||key==101||key==102||key==103||key==104||key==105||key==106||key==107||key==108||key==109||key==110||key==111||key==112||key==113||key==114||key==115||key==116||key==117||key==118||key==119||key==120||key==121||key==122)
            {
              alert("你刚刚敲击了字母键["+String.fromCharCode(key)+"]!");
            }
          }
          
          function warn(node)
          {
          alert("您刚刚点击了一个文本框.");
          }
        </script>
        <title>Protocol Manager v1.0 for Hexempire API Project</title>
      </head>
      <body>
        <h2>Protocol Manager v1.0</h2>
        <hr />
        <p>Available protocols : <xsl:value-of select="protocols/size"/></p>
        <table border="1">
          <tr bgcolor="#9acd32">
            <th>Instruction</th>
            <th>ID</th>
            <th>Entry 3</th>
            <th>Entry 2</th>
            <th>Entry 1</th>
            <th>Entry 0</th>
          </tr>
          <xsl:for-each select="protocols/instructions">
            <xsl:sort select="id"/>
            <tr>
              <td align="left"><xsl:value-of select="name"/></td>
              <td align="right"><xsl:value-of select="id"/></td>
              <xsl:for-each select="entries">
                <td>
                  <input type="text" onkeypress="confirm(event,this)" onclick="warn(this)"><xsl:value-of select="name"/></input>
                </td>
              </xsl:for-each>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>