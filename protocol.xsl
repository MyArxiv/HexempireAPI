<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
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
                <td align="right">
                  <xsl:value-of select="name"/>
                </td>
              </xsl:for-each>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>