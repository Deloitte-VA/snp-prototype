var conn;
try
{
    conn = new Mongo();
}
catch(Error)
{
    //print(Error);
}
while(conn===undefined)
{
    try
    {
        conn = new Mongo();
    }
    catch(Error)
    {
        //print(Error);
    }
    sleep(100);
}
