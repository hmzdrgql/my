/**
 * Created by lenovo on 2017/9/12.
 */
$(function(){
    //alert("ssssssssssssddddddddd");
})

function CreateFile()
{
    var fso, tf;
    fso = new ActiveXObject("Scripting.FileSystemObject");//获取对象
    tf = fso.CreateTextFile("d:\\testfile.txt", true);//创建一个文件夹
    // 写一行，并且带有新行字符。
    tf.WriteLine("Testing 1, 2, 3.") ;
    // 向文件写三个新行字符。
    tf.WriteBlankLines(3) ;
    // 写一行。
    tf.Write ("This is a test.");
    tf.Close();//关闭
}
/**
 *Folder的API：
 *任务 方法
 *创建文件夹。 FileSystemObject.CreateFolder
 *删除文件夹。 Folder.Delete 或 FileSystemObject.DeleteFolder
 *移动文件夹。 Folder.Move 或 FileSystemObject.MoveFolder
 *复制文件夹。 Folder.Copy 或 FileSystemObject.CopyFolder
 *检索文件夹的名字。 Folder.Name
 *如果文件夹在驱动器上存在，则找出它。 FileSystemObject.FolderExists
 *获得现有 Folder 对象的实例。 FileSystemObject.GetFolder
 *找出文件夹的父文件夹名。 FileSystemObject.GetParentFolderName
 *找出系统文件夹的路径。 FileSystemObject.GetSpecialFolder
 */
function ManipFiles()
{
    alert("is do!");
    var fso, f1, f2, s, xmlHttp;
    //if(window.ActiveXObject)
    //{
    //    var aVersions =["MSXML2.XMLHttp.5.0","MSXML2.XMLHttp.4.0","MSXML2.XMLHttp.3.0","MSXML2.XMLHttp","Microsoft.XMLHttp"];
    //    for(var i=0;i<aVersions.length;i++){
    //        try
    //        {
    //            xmlHttp = new ActiveXObject(aVersions[i]);
    //            return;
    //        }
    //        catch(oError)
    //        {
    //        }
    //    }
    //}
    //else if(window.XMLHttpRequest)
    //{
    //    xmlHttp = new XMLHttpRequest();
    //    //return;
    //}
    fso = new ActiveXObject("Scripting.FileSystemObject");
    //alert("Moving file to c:\\tmp ");
    //if(!fso.FolderExists("localhost\\LENOVO-PC\\data\\tmp")) { //如果tmp目录不存在，则创建一个目录
    //    fso.CreateFolder("localhost\\LENOVO-PC\\data\\tmp");
    //}
    //f1 = fso.CreateTextFile("localhost\\LENOVO-PC\\data\\tmp\\testfile.txt", true); //如果当前文件已经存在的话，则覆盖原有文件
    f1 = fso.CreateTextFile("localhost\\LENOVO-PC\\data\\testfile.txt", true);
    // 写一行。
    f1.Write("This is a test.");
    // 关闭文件。
    f1.Close();
    //// 获取 C 的根目录(C:\)中的文件的句柄。
    //f2 = fso.GetFile("d:\\testfile.txt");
    //// 把文件移动到 \tmp 目录。如果这个tmp目录下已经有testfile.txt文件了，则会出错。（如果没有tmp这个文件目录也会出错）
    //f2.Move ("d:\\tmp\\testfile.txt");
    //alert("Copying file to d:\\temp ");
    //// 把文件复制到 \temp 目录
    //if(!fso.FolderExists("d:\\temp")) {//如果temp目录不存在，则创建一个目录
    //    fso.CreateFolder("d:\\temp");
    //}
    //f2.Copy ("d:\\temp\\testfile.txt");
    //alert("Deleting files ");
    //// 获得文件当前位置的句柄。
    //f2 = fso.GetFile("d:\\tmp\\testfile.txt");
    //f3 = fso.GetFile("d:\\temp\\testfile.txt");
    //// 删除文件。
    //f2.Delete();
    //f3.Delete();
    ////删除文件夹
    //var fdTmp = fso.GetFolder("d:\\tmp");
    //var fdTemp = fso.GetFolder("d:\\temp");
    //fdTmp.DeleteFolder();
    //fdTemp.DeleteFolder();
    alert("All done!");
}
ManipFiles();
//CreateFile();