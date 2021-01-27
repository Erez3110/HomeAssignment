package Utilities;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;

public class helperMethods extends commonOps
{
    public static String getText(Part p) throws MessagingException, IOException
    {
        if (p.isMimeType("text/*"))
        {
            String s = (String) p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return s;
        }

        if (p.isMimeType("multipart/alternative"))
        {
            Multipart mp = (Multipart) p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++)
            {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain"))
                {
                    if (text == null)
                        text = getText(bp);
                    continue;
                } else if (bp.isMimeType("text/html"))
                {
                    String s = getText(bp);
                    if (s != null)
                        return s;
                } else
                {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*"))
        {
            Multipart mp = (Multipart) p.getContent();
            for (int i = 0; i < mp.getCount(); i++)
            {
                String s = getText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }
        return null;
    }

    public static boolean textIsHtml = false;

    public static String trimMailBody(String body)
    {
        String[] temp = body.split(">");
        String[] trimmedBody = temp[1].split("<");
        return trimmedBody[0];
    }

    public static String getCell(int row, int column)
    {
        FileInputStream fis= null;
        try
        {
            fis = new FileInputStream(new File(getData("excel_w3schools")));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        HSSFWorkbook wb= null;

        try
        {
            assert fis != null;
            wb = new HSSFWorkbook(fis);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        assert wb != null;
        HSSFSheet sheet=wb.getSheetAt(0);
        return String.valueOf(sheet.getRow(row).getCell(column));
    }
}

