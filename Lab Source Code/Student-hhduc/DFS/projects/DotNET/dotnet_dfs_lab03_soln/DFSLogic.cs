using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Emc.Documentum.FS.Runtime.Context;
using Emc.Documentum.FS.DataModel.Core;
using Emc.Documentum.FS.DataModel.Core.Properties;
using Emc.Documentum.FS.DataModel.Core.Context;
using Emc.Documentum.FS.Services.Core;
using Emc.Documentum.FS.DataModel.Core.Profiles;
using Emc.Documentum.FS.DataModel.Core.Content;

namespace DotNETDFS
{
    class DFSLogic
    {

        public static void startLogic(String repository, String userName, String password)
        {
            IServiceContext context = createContext(repository, userName, password);
            
            //comment block 'new service'

            Console.Out.WriteLine("Creating new IObjectService instance...");

            //create a service factory and instatiate the IObjectService
            ServiceFactory sf = ServiceFactory.Instance;
            IObjectService objectService =
                sf.GetRemoteService<IObjectService>(context);

            //comment block 'build'

            Console.Out.WriteLine("Creating new ObjectIdentiy instance...");

            //build object identity
            ObjectIdentity docIdent = new ObjectIdentity();
            docIdent.RepositoryName = repository;

            Console.Out.WriteLine("Creating new DataObject instance...");

            //build data object, seed with object identity
            DataObject dataObj = new DataObject(docIdent, "dm_document");

            Console.Out.WriteLine("Creating new PropertySet instance...");

            //build property set
            String objName = "lab03_test";
            PropertySet propertySet = new PropertySet();
            propertySet.Set("object_name", objName);

            //seed data object with property set
            dataObj.Properties = propertySet;

            Console.Out.WriteLine("Creating new DataPackage instance...");

            //build data package, seed with data object
            DataPackage dataPack = new DataPackage(dataObj);

            Console.Out.WriteLine("Calling the IObjectService.create() method...");

            OperationOptions options = null;

            //call the create method
            objectService.Create(dataPack, options);

            Console.Out.WriteLine("A new object called '" + objName + "' has been created...");

        }

        private static IServiceContext createContext(String repository, String userName, String password)
        {
            Console.Out.WriteLine("Creating new empty IServiceContext instance...");

            //build context factory and an empty context
            ContextFactory cf = ContextFactory.Instance;
            IServiceContext context = cf.NewContext();

            Console.Out.WriteLine("Creating new repository identity...");

            //create a repository ID and seed it with the login credentials
            RepositoryIdentity repoIdent = new RepositoryIdentity(repository, userName, password, "");

            Console.Out.WriteLine("Adding repository ID into IServiceContext object...");

            //seed the IServiceContext with the Repository ID
            context.AddIdentity(repoIdent);

            ContentTransferProfile ctp = new ContentTransferProfile();
            ctp.TransferMode = ContentTransferMode.BASE64;
            context.SetProfile(ctp);

            return context;
        }
    }
}
