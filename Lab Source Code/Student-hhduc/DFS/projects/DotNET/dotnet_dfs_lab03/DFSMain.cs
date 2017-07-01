using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Emc.Documentum.FS.Runtime;

namespace DotNETDFS
{
    class DFSMain
    {
        private String _repository;
        private String _userName;
        private String _password;

        ///////////////////////////////////////////////////////////////////////////
        // args[0] should be the repository name
        // args[1] should be the user name
        // args[2] should be the password
        static void Main(string[] args)
        {

            if (args.Length < 3)
            {
                Console.Out.WriteLine("Missing required arguments!");
                Console.Out.WriteLine("The required areguments are <repository> <user name> <password>");
                return;
            }

            DFSMain main = new DFSMain();
            main._repository = args[0];
            main._userName = args[1];
            main._password = args[2];

            //Console.Out.WriteLine("repository = '" + main._repository + "'");
            //Console.Out.WriteLine("user name = '" + main._userName + "'");
            //Console.Out.WriteLine("password = '" + main._password + "'");

            try
            {
                Console.Out.WriteLine("Starting Program...");
                DFSLogic.startLogic(main._repository, main._userName, main._password);
            }

            catch (Exception e)
            {
                Console.Out.WriteLine(e.Message);
                Console.Out.WriteLine(e.StackTrace);
            }

            Console.Out.WriteLine("Finished");
        }

        ///////////////////////////////////////////////////////////////////////////

        public DFSMain()
        {
            this._repository = "";
            this._userName = "";
            this._password = "";
        }
        ///////////////////////////////////////////////////////////////////////////
    }
}
