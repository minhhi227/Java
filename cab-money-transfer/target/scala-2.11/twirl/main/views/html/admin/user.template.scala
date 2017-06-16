
package views.html.admin

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object user extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[User,List[Branch],List[Role],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User, branchList: List[Branch], roleList: List[Role], nav: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import utils.DateUtils

Seq[Any](format.raw/*1.75*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("USER", user, nav, null, null, null)/*5.43*/ {_display_(Seq[Any](format.raw/*5.45*/("""

	"""),format.raw/*7.2*/("""<!-- Default tab for admin is User tab -->
	
	<div class="content-wrapper">
		<div class="page-header"><h3>List user</h3></div>
		<table id="tbUser" class="display cell-border compact" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>N&deg;</th>
					<th>ID</th>
					<th>Branch</th>
					<th>Username</th>					
					<th>Role</th>
					<th>Full name</th>
					<th>Date of Birth</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Address</th>
					<th>Active</th>
					<th>BranchId</th>
					<th>RoleId</th>
					<th>Password</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	
<!-- pop up create or update user-->
<div id="popupAddEditUser" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="popupAddEditUser" aria-hidden="true" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title" id="popupAddEditUserTitle">Create User</h4>
			</div>
			<form role="form" id="frmUser" data-toggle="validator" action="javascript:return;" method="post">
				<div class="modal-body">
					<input type="hidden" name="userId" id="userId" value="0"/>
					<div id="user-alert-success" class="alert alert-success hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Saved successfully</div>
					<div id="user-alert-warning" class="alert alert-warning hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Username exists</div>
					<div id="user-alert-danger" class="alert alert-danger hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>JSON expected</div>
					
					<div class="row"> <!-- Row 1 -->
						<div class="col-md-6 form-group">
							<label class="control-label">Full Name</label>
							<input type="text" name="fullName" class="form-control" placeholder="full name" required/>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">Date of Birth</label>
			                <div class="input-group">
			                    <input type="text" name="dateOfBirth" id="dpDateOfBirth" class="form-control" placeholder="date of birth"/>
			                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                </div>
						</div>
					</div>
					<div class="row"> <!-- Row 2 -->
						<div class="col-md-6 form-group">
							<label class="control-label">Phone</label>
							<input type="text" name="phone" class="form-control" placeholder="phone"/>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">Email</label>
							<input type="email" name="email" class="form-control" placeholder="email"/>
						</div>
					</div>
					<div class="row"> <!-- Row 3 -->
						<div class="col-md-12 form-group">
							<label class="control-label">Address</label>
							<textarea name="address" class="form-control" rows="2" placeholder="address" maxLength="255"></textarea>	
						</div>				
					</div>	
					<div class="row"> <!-- Row 4 -->
						<div class="col-md-6 form-group">
							<div class="row">
								<div class="col-md-6">
									<label class="control-label">Branch</label>
								</div>
							</div>
							<div class="row">
								<div class="col-md-10" style="padding-right:0px;">
									<select class="form-control" name="branch" required>
									"""),_display_(/*88.11*/if(branchList != null)/*88.33*/{_display_(Seq[Any](format.raw/*88.34*/("""
										"""),_display_(/*89.12*/for(branch <- branchList) yield /*89.37*/{_display_(Seq[Any](format.raw/*89.38*/("""
											"""),format.raw/*90.12*/("""<option value=""""),_display_(/*90.28*/branch/*90.34*/.getId()),format.raw/*90.42*/("""">"""),_display_(/*90.45*/branch/*90.51*/.getName()),format.raw/*90.61*/("""</option>
										""")))}),format.raw/*91.12*/("""
									""")))}),format.raw/*92.11*/("""
									"""),format.raw/*93.10*/("""</select>								
								 </div>
								<div class="col-md-1" style="padding-left:0px;">
									<button type="button" id="btnAddBranch" class="btn btn-default pull-left" style="height: 29px;"><span class="glyphicon glyphicon-plus-sign"></span></button>
								 </div>
							</div>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">Role</label>
							<select class="form-control" name="role" required>
							"""),_display_(/*103.9*/if(roleList != null)/*103.29*/{_display_(Seq[Any](format.raw/*103.30*/("""
								"""),_display_(/*104.10*/for(role <- roleList) yield /*104.31*/{_display_(Seq[Any](format.raw/*104.32*/("""
									"""),format.raw/*105.10*/("""<option value=""""),_display_(/*105.26*/role/*105.30*/.getId()),format.raw/*105.38*/("""">"""),_display_(/*105.41*/role/*105.45*/.getLabel()),format.raw/*105.56*/("""</option>
								""")))}),format.raw/*106.10*/("""
							""")))}),format.raw/*107.9*/("""
							"""),format.raw/*108.8*/("""</select>
						</div>
					</div>
					<div class="row"> <!-- Row 5 -->
						<div class="col-md-6 form-group">
							<label class="control-label">Username</label>
							<input type="text" name="username" class="form-control" placeholder="username" required/>	
						</div>	
						<div class="col-md-6 form-group">
							<label class="control-label">Active</label>
							<input type="checkbox" name="active" class="form-control" data-on-text="YES" data-off-text="NO" data-on-color="primary"/>
						</div>			
					</div>
					<div class="row"> <!-- Row 6 -->
						<div class="col-md-6 form-group">
							<label class="control-label">Password</label>
							<input type="password" name="password" id="password" class="form-control" placeholder="password" required/>
						</div>	
						<div class="col-md-6 form-group">
							<label class="control-label">Re-enter password</label>
							<input type="password" name="confirmPassword" class="form-control" placeholder="re-enter password" required/>	
						</div>			
					</div>
					
				</div>
				<div class="modal-footer">
					<button id="btnSaveUser" type="submit" class="btn btn-primary">Save</button>
					<button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- end pop up create or update user -->

<!-- pop up save or update branch-->
<div id="popupSaveOrUpdateBranch" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="popupSaveOrUpdateBranch" aria-hidden="true" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title" id="popupSaveOrUpdateBranchTitle">Add New Branch</h4>
			</div>
			<form role="form" id="frmBranch" action=""""),_display_(/*151.46*/routes/*151.52*/.UserController.saveOrUpdateBranch()),format.raw/*151.88*/("""" method="post">
				<div class="modal-body">
					<div id="branch-alert-success" class="alert alert-success hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Saved successfully</div>
					<div id="branch-alert-warning" class="alert alert-warning hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Branch exists</div>
					<div id="branch-alert-danger" class="alert alert-danger hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>JSON expected</div>
					<input type="hidden" name="branchId" id="branchId" value="0"/>
					<div class="row"> <!-- Row 1 -->
						<div class="col-md-6 form-group">
							<label class="control-label">Name</label>
							<input type="text" name="branchName" class="form-control" placeholder="name" required/>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">Phone</label>
							<input type="text" name="branchPhone" class="form-control" placeholder="phone"/>
						</div>
					</div>
					<div class="row"> <!-- Row 2 -->
						<div class="col-md-6 form-group">
							<label class="control-label">Bank Ref.</label>
							<input type="text" name="branchBankRef" class="form-control" placeholder="bank ref." required/>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">Init Bank Code</label>
							<input type="text" name="branchInitBankCode" class="form-control" value="1" required/>
						</div>
					</div>					
					<div class="row"> <!-- Row 3 -->
						<div class="col-md-12 form-group">
							<label class="control-label">Address</label>
							<textarea name="branchAddress" class="form-control" rows="2" placeholder="address" maxLength="255"></textarea>	
						</div>				
					</div>
				</div>
				<div class="modal-footer">
					<button id="btnSaveBranch" type="submit" class="btn btn-primary">Save</button>
					<button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- end pop up save or update branch-->

	<!-- jQuery -->
	<script src=""""),_display_(/*195.16*/routes/*195.22*/.Assets.at("javascripts/jquery-1.11.1.min.js")),format.raw/*195.68*/(""""></script>
	<!-- JS Bootstrap -->		
	<script type="text/javascript" src=""""),_display_(/*197.39*/routes/*197.45*/.Assets.at("bootstrap/js/bootstrap.min.js")),format.raw/*197.88*/("""" defer></script>
	<!-- JS Bootstrap Switch -->
	<script type="text/javascript" src=""""),_display_(/*199.39*/routes/*199.45*/.Assets.at("bootstrap/js/bootstrap-switch.min.js")),format.raw/*199.95*/("""" defer></script>
	<!-- JS fnReloadAjax -->
	<script type="text/javascript" language="javascript" src=""""),_display_(/*201.61*/routes/*201.67*/.Assets.at("plugins/datatables-1.10.2/fnReloadAjax.js")),format.raw/*201.122*/("""" defer></script>
	
	<script type="text/javascript" language="javascript">
		var colNo = 0;
		var colId = 1;
		var colBranch = 2;
		var colUsername = 3;
		var colRole = 4;
		var colFullName = 5;
		var colDateOfBirth = 6;
		var colPhone = 7;
		var colEmail = 8;
		var colAddress = 9;
		var colActive = 10;
		var colBranchId = 11;
		var colRoleId = 12;
		var colPassword = 13;
		var i=0;

		var tbUser
		
		$(document).ready(function() """),format.raw/*222.32*/("""{"""),format.raw/*222.33*/("""
			
			"""),format.raw/*224.4*/("""/*
			* dataTables : tbUser
			*/
			tbUser = $('#tbUser').dataTable("""),format.raw/*227.36*/("""{"""),format.raw/*227.37*/("""
				"""),format.raw/*228.5*/("""columnDefs: [ 
					"""),format.raw/*229.6*/("""{"""),format.raw/*229.7*/("""targets:[colNo], sortable:false,orderable: false,searchable:false"""),format.raw/*229.72*/("""}"""),format.raw/*229.73*/(""",
					"""),format.raw/*230.6*/("""{"""),format.raw/*230.7*/("""targets:[colId], visible:false, searchable:false"""),format.raw/*230.55*/("""}"""),format.raw/*230.56*/(""",
					"""),format.raw/*231.6*/("""{"""),format.raw/*231.7*/("""targets:[colEmail], visible:false, searchable:false"""),format.raw/*231.58*/("""}"""),format.raw/*231.59*/(""",
					"""),format.raw/*232.6*/("""{"""),format.raw/*232.7*/("""targets:[colAddress], visible:false, searchable:false"""),format.raw/*232.60*/("""}"""),format.raw/*232.61*/(""",
					"""),format.raw/*233.6*/("""{"""),format.raw/*233.7*/("""targets:[colBranchId], visible:false, searchable:false"""),format.raw/*233.61*/("""}"""),format.raw/*233.62*/(""",
					"""),format.raw/*234.6*/("""{"""),format.raw/*234.7*/("""targets:[colRoleId], visible:false, searchable:false"""),format.raw/*234.59*/("""}"""),format.raw/*234.60*/(""",
					"""),format.raw/*235.6*/("""{"""),format.raw/*235.7*/("""targets:[colPassword], visible:false, searchable:false"""),format.raw/*235.61*/("""}"""),format.raw/*235.62*/("""
				"""),format.raw/*236.5*/("""],
				dom: 'fl<"toolbar">tip',
				pagingType: "full_numbers",
				displayLength: 10,
				deferLoading: 0,
	            serverSide: true,	
	            processing: true,
	            stateSave: true,
				ajaxSource: """"),_display_(/*244.19*/routes/*244.25*/.UserController.filterUser()),format.raw/*244.53*/("""",
<!--		        createdRow: function ( row, data, index ) """),format.raw/*245.57*/("""{"""),format.raw/*245.58*/("""-->
<!--		        	$('#tbUser tbody').children().eq(index).children().eq(colNo).html(index + 1);-->
<!--		        """),format.raw/*247.15*/("""}"""),format.raw/*247.16*/(""",-->
				fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) """),format.raw/*248.78*/("""{"""),format.raw/*248.79*/("""
					"""),format.raw/*249.6*/("""$('td', nRow).on('dblclick', function() """),format.raw/*249.46*/("""{"""),format.raw/*249.47*/(""" 
						"""),format.raw/*250.7*/("""preparePopupBeforeEditUser(aData);
						$('#popupAddEditUser').modal("show");
					"""),format.raw/*252.6*/("""}"""),format.raw/*252.7*/("""); 
				"""),format.raw/*253.5*/("""}"""),format.raw/*253.6*/("""
			"""),format.raw/*254.4*/("""}"""),format.raw/*254.5*/(""");

			tbUser.fnReloadAjax();
		
			$("div.toolbar").html('&nbsp;<a id="btnAddUser" class="btn btn-primary">Add</a>');

			/* date picker date of birth */
			var dpDateOfBirth = new dhtmlXCalendarObject(["dpDateOfBirth"]);
			dpDateOfBirth.setDateFormat("%d/%m/%Y");

			$('#btnAddUser').click(function()"""),format.raw/*264.37*/("""{"""),format.raw/*264.38*/("""
				"""),format.raw/*265.5*/("""preparePopupBeforeAddUser();
				$('#popupAddEditUser').modal("show");
			"""),format.raw/*267.4*/("""}"""),format.raw/*267.5*/(""");
			
			$('#btnAddBranch').click(function()"""),format.raw/*269.39*/("""{"""),format.raw/*269.40*/("""
				"""),format.raw/*270.5*/("""preparePopupBeforeAddBranch();
				$('#popupSaveOrUpdateBranch').modal("show");
			"""),format.raw/*272.4*/("""}"""),format.raw/*272.5*/(""");
			
			function preparePopupBeforeEditUser(dr)"""),format.raw/*274.43*/("""{"""),format.raw/*274.44*/("""
				"""),format.raw/*275.5*/("""$('#popupAddEditUserTitle').html('Edit User');
				$('#btnSaveUser').html('Update');
				
				$('#userId').val(dr[colId]);
				$("input[name='username']").val(dr[colUsername]);
				$("select[name='branch']").val(dr[colBranchId]);
				$("select[name='role']").val(dr[colRoleId]);
				$("input[name='fullName']").val(dr[colFullName]);
				$("input[name='dateOfBirth']").val(dr[colDateOfBirth]);
				$("input[name='phone']").val(dr[colPhone]);
				$("input[name='email']").val(dr[colEmail]);
				$("textarea[name='address']").val(dr[colAddress]);
				$("input[name='active']").bootstrapSwitch('state', (dr[colActive] == true));
				$("input[name='password']").val(dr[colPassword]);
				$("input[name='confirmPassword']").val(dr[colPassword]);
			"""),format.raw/*290.4*/("""}"""),format.raw/*290.5*/("""

			"""),format.raw/*292.4*/("""function preparePopupBeforeAddUser()"""),format.raw/*292.40*/("""{"""),format.raw/*292.41*/("""
				"""),format.raw/*293.5*/("""clearPopupControls();
				$('#popupAddEditUserTitle').html('Create User');
				$('#btnSaveUser').html('Save');
			"""),format.raw/*296.4*/("""}"""),format.raw/*296.5*/("""
			
			"""),format.raw/*298.4*/("""function preparePopupBeforeAddBranch()"""),format.raw/*298.42*/("""{"""),format.raw/*298.43*/("""
				"""),format.raw/*299.5*/("""$("input[name='branchName']").val('');
				$("input[name='branchPhone']").val('');
				$("textarea[name='branchAddress']").val('');
				$('#popupSaveOrUpdateBranchTitle').html('Add New Branch');
				$('#btnSaveBranch').html('Save');
			"""),format.raw/*304.4*/("""}"""),format.raw/*304.5*/("""
			
			"""),format.raw/*306.4*/("""function clearPopupControls()"""),format.raw/*306.33*/("""{"""),format.raw/*306.34*/("""
				"""),format.raw/*307.5*/("""$('#userId').val('0');
				$("input[name='username']").val('');
				$("input[name='fullName']").val('');
				$("input[name='dateOfBirth']").val('');
				$("input[name='phone']").val('');
				$("input[name='email']").val('');
				$("textarea[name='address']").val('');
				$("input[name='active']").bootstrapSwitch('state', true);
				$("input[name='password']").val('');
				$("input[name='confirmPassword']").val('');				
			"""),format.raw/*317.4*/("""}"""),format.raw/*317.5*/("""

			"""),format.raw/*319.4*/("""$('#popupAddEditUser').on('hide.bs.modal', function () """),format.raw/*319.59*/("""{"""),format.raw/*319.60*/("""
				"""),format.raw/*320.5*/("""$('form#frmUser').bootstrapValidator('resetForm', true);
			"""),format.raw/*321.4*/("""}"""),format.raw/*321.5*/(""")
			
			/* validate form User and submit */
			// revalidate datePicker after clicking a date
			dpDateOfBirth.attachEvent("onClick", function(date)"""),format.raw/*325.55*/("""{"""),format.raw/*325.56*/("""
				"""),format.raw/*326.5*/("""$('form#frmUser').bootstrapValidator('revalidateField', 'dateOfBirth');
			"""),format.raw/*327.4*/("""}"""),format.raw/*327.5*/(""");			
		    $('form#frmUser').bootstrapValidator("""),format.raw/*328.44*/("""{"""),format.raw/*328.45*/("""
		    	"""),format.raw/*329.8*/("""excluded: [':disabled', ':hidden', ':not(:visible)'],
		    	live: 'enabled',
		    	container: 'tooltip',
		        feedbackIcons: """),format.raw/*332.26*/("""{"""),format.raw/*332.27*/("""
		            """),format.raw/*333.15*/("""valid: 'glyphicon',
		            invalid: 'glyphicon',
		            validating: 'glyphicon glyphicon-refresh'
		        """),format.raw/*336.11*/("""}"""),format.raw/*336.12*/(""",
		        fields: """),format.raw/*337.19*/("""{"""),format.raw/*337.20*/("""
		            """),format.raw/*338.15*/("""fullName: """),format.raw/*338.25*/("""{"""),format.raw/*338.26*/("""
		                """),format.raw/*339.19*/("""validators: """),format.raw/*339.31*/("""{"""),format.raw/*339.32*/("""
		                    """),format.raw/*340.23*/("""regexp: """),format.raw/*340.31*/("""{"""),format.raw/*340.32*/("""
		                        """),format.raw/*341.27*/("""regexp: /^[a-z\s]+$/i,
		                        message: 'The full name can consist of alphabetical characters and spaces only'
		                    """),format.raw/*343.23*/("""}"""),format.raw/*343.24*/("""		                    
		                """),format.raw/*344.19*/("""}"""),format.raw/*344.20*/("""
		            """),format.raw/*345.15*/("""}"""),format.raw/*345.16*/(""",
		            dateOfBirth: """),format.raw/*346.28*/("""{"""),format.raw/*346.29*/("""
		                """),format.raw/*347.19*/("""validators: """),format.raw/*347.31*/("""{"""),format.raw/*347.32*/("""
		                	"""),format.raw/*348.20*/("""date: """),format.raw/*348.26*/("""{"""),format.raw/*348.27*/("""
		                		"""),format.raw/*349.21*/("""format: 'DD/MM/YYYY',
		                		message: 'Invalid date'
		                	"""),format.raw/*351.20*/("""}"""),format.raw/*351.21*/("""               
		                """),format.raw/*352.19*/("""}"""),format.raw/*352.20*/("""
		            """),format.raw/*353.15*/("""}"""),format.raw/*353.16*/(""",		            
	                password: """),format.raw/*354.28*/("""{"""),format.raw/*354.29*/("""
	                    """),format.raw/*355.22*/("""validators: """),format.raw/*355.34*/("""{"""),format.raw/*355.35*/("""
	                        """),format.raw/*356.26*/("""identical: """),format.raw/*356.37*/("""{"""),format.raw/*356.38*/("""
	                            """),format.raw/*357.30*/("""field: 'confirmPassword',
	                        	message: 'Passwords do not match'
	                        """),format.raw/*359.26*/("""}"""),format.raw/*359.27*/(""",
	                    	stringLength: """),format.raw/*360.37*/("""{"""),format.raw/*360.38*/("""
	                    		"""),format.raw/*361.24*/("""min: 6,
	                    		message: 'Min is 6 characters long'
	                    	"""),format.raw/*363.23*/("""}"""),format.raw/*363.24*/("""	                        
	                    """),format.raw/*364.22*/("""}"""),format.raw/*364.23*/("""
	                """),format.raw/*365.18*/("""}"""),format.raw/*365.19*/(""",
	                confirmPassword: """),format.raw/*366.35*/("""{"""),format.raw/*366.36*/("""
	                    """),format.raw/*367.22*/("""validators: """),format.raw/*367.34*/("""{"""),format.raw/*367.35*/("""
	                        """),format.raw/*368.26*/("""identical: """),format.raw/*368.37*/("""{"""),format.raw/*368.38*/("""
	                            """),format.raw/*369.30*/("""field: 'password',
	                        	message: 'Passwords do not match'
	                        """),format.raw/*371.26*/("""}"""),format.raw/*371.27*/(""",
	                    	stringLength: """),format.raw/*372.37*/("""{"""),format.raw/*372.38*/("""
	                    		"""),format.raw/*373.24*/("""min: 6,
	                    		message: 'Min is 6 characters long'
	                    	"""),format.raw/*375.23*/("""}"""),format.raw/*375.24*/("""	                        
	                    """),format.raw/*376.22*/("""}"""),format.raw/*376.23*/("""
	                """),format.raw/*377.18*/("""}"""),format.raw/*377.19*/("""
		        """),format.raw/*378.11*/("""}"""),format.raw/*378.12*/("""
		    """),format.raw/*379.7*/("""}"""),format.raw/*379.8*/(""")
		    .on('success.form.bv', function(e) """),format.raw/*380.42*/("""{"""),format.raw/*380.43*/("""
		    	"""),format.raw/*381.8*/("""e.preventDefault(); // Prevent submit form 
				var that = $(this),
				url = that.attr('action'),
				type = that.attr('method'),
				data = """),format.raw/*385.12*/("""{"""),format.raw/*385.13*/("""}"""),format.raw/*385.14*/(""";
				that.find('[name]').each(function(index, value)"""),format.raw/*386.52*/("""{"""),format.raw/*386.53*/("""
					"""),format.raw/*387.6*/("""var that = $(this),
						name = that.attr('name'),
						value = that.val();
					if(that.attr('type') != null && that.attr('type')=='checkbox')"""),format.raw/*390.68*/("""{"""),format.raw/*390.69*/("""
						"""),format.raw/*391.7*/("""data[name] = that.prop('checked');
					"""),format.raw/*392.6*/("""}"""),format.raw/*392.7*/("""else"""),format.raw/*392.11*/("""{"""),format.raw/*392.12*/("""
						"""),format.raw/*393.7*/("""data[name] = value;
					"""),format.raw/*394.6*/("""}"""),format.raw/*394.7*/("""
				"""),format.raw/*395.5*/("""}"""),format.raw/*395.6*/(""");
				data['updateTime'] = new Date().getTime();
				$.ajax("""),format.raw/*397.12*/("""{"""),format.raw/*397.13*/("""
	       			"""),format.raw/*398.12*/("""url: '"""),_display_(/*398.19*/routes/*398.25*/.UserController.saveOrUpdateUser()),format.raw/*398.59*/("""',
	       			type: type,
	       			dataType: 'json',
	       			data: JSON.stringify(data),
	       			contentType : "application/json",
	       			success: function(response) """),format.raw/*403.40*/("""{"""),format.raw/*403.41*/("""
	       				"""),format.raw/*404.13*/("""if(response == 'user_exists')"""),format.raw/*404.42*/("""{"""),format.raw/*404.43*/("""
	       					"""),format.raw/*405.14*/("""$('#user-alert-warning').removeClass('hidden');
			       			setTimeout(function()"""),format.raw/*406.35*/("""{"""),format.raw/*406.36*/("""
			       				"""),format.raw/*407.15*/("""$('#user-alert-warning').addClass('hidden');
			       			"""),format.raw/*408.14*/("""}"""),format.raw/*408.15*/(""", 3000);
				       	"""),format.raw/*409.13*/("""}"""),format.raw/*409.14*/("""else if(response == 'json_expected')"""),format.raw/*409.50*/("""{"""),format.raw/*409.51*/("""
				       		"""),format.raw/*410.14*/("""$('#user-alert-danger').removeClass('hidden');
			       			setTimeout(function()"""),format.raw/*411.35*/("""{"""),format.raw/*411.36*/("""
			       				"""),format.raw/*412.15*/("""$('#user-alert-danger').addClass('hidden');
			       			"""),format.raw/*413.14*/("""}"""),format.raw/*413.15*/(""", 3000);
					    """),format.raw/*414.10*/("""}"""),format.raw/*414.11*/("""else"""),format.raw/*414.15*/("""{"""),format.raw/*414.16*/("""
					    	"""),format.raw/*415.11*/("""tbUser.fnReloadAjax();
			       			$('#user-alert-success').removeClass('hidden');
					    	$("#user-alert-success").slideDown("slow");
							window.setTimeout(function()"""),format.raw/*418.36*/("""{"""),format.raw/*418.37*/("""$("#user-alert-success").slideUp("slow");"""),format.raw/*418.78*/("""}"""),format.raw/*418.79*/(""",2000);
							$('#frmUser').data('bootstrapValidator').resetForm();
							$('#frmUser').find('input[type="text"],input[type="password"],input[type="email"],textarea').val("");
			       		"""),format.raw/*421.13*/("""}"""),format.raw/*421.14*/("""
		       		"""),format.raw/*422.12*/("""}"""),format.raw/*422.13*/(""",
		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*423.62*/("""{"""),format.raw/*423.63*/("""
		            	"""),format.raw/*424.16*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*424.102*/("""{"""),format.raw/*424.103*/("""}"""),format.raw/*424.104*/(""");
		            """),format.raw/*425.15*/("""}"""),format.raw/*425.16*/("""
		       	"""),format.raw/*426.11*/("""}"""),format.raw/*426.12*/(""");
			    return false;
		    """),format.raw/*428.7*/("""}"""),format.raw/*428.8*/(""");


		    /* Validate form Branch and submit */
		    $('#frmBranch').bootstrapValidator("""),format.raw/*432.42*/("""{"""),format.raw/*432.43*/("""
		    	"""),format.raw/*433.8*/("""excluded: [':disabled', ':hidden', ':not(:visible)'],
		    	live: 'enabled',
		    	container: 'tooltip',
		        feedbackIcons: """),format.raw/*436.26*/("""{"""),format.raw/*436.27*/("""
		            """),format.raw/*437.15*/("""valid: 'glyphicon',
		            invalid: 'glyphicon',
		            validating: 'glyphicon glyphicon-refresh'
		        """),format.raw/*440.11*/("""}"""),format.raw/*440.12*/("""
		    """),format.raw/*441.7*/("""}"""),format.raw/*441.8*/(""")
		    .on('success.form.bv', function(e) """),format.raw/*442.42*/("""{"""),format.raw/*442.43*/("""
		    	"""),format.raw/*443.8*/("""e.preventDefault(); // Prevent submit form 
				var that = $(this),
				url = that.attr('action'),
				type = that.attr('method'),
				data = """),format.raw/*447.12*/("""{"""),format.raw/*447.13*/("""}"""),format.raw/*447.14*/(""";
				that.find('[name]').each(function(index, value)"""),format.raw/*448.52*/("""{"""),format.raw/*448.53*/("""
					"""),format.raw/*449.6*/("""var that = $(this),
						name = that.attr('name'),
						value = that.val();
					if(that.attr('type') != null && that.attr('type')=='checkbox')"""),format.raw/*452.68*/("""{"""),format.raw/*452.69*/("""
						"""),format.raw/*453.7*/("""data[name] = that.prop('checked');
					"""),format.raw/*454.6*/("""}"""),format.raw/*454.7*/("""else"""),format.raw/*454.11*/("""{"""),format.raw/*454.12*/("""
						"""),format.raw/*455.7*/("""data[name] = value;
					"""),format.raw/*456.6*/("""}"""),format.raw/*456.7*/("""
				"""),format.raw/*457.5*/("""}"""),format.raw/*457.6*/(""");
				data['updateTime'] = new Date().getTime();
				$.ajax("""),format.raw/*459.12*/("""{"""),format.raw/*459.13*/("""
	       			"""),format.raw/*460.12*/("""url: url,
	       			type: type,
	       			dataType: 'json',
	       			data: JSON.stringify(data),
	       			contentType : "application/json",
	       			success: function(response) """),format.raw/*465.40*/("""{"""),format.raw/*465.41*/("""
	       				"""),format.raw/*466.13*/("""if(response == 'branch_exists')"""),format.raw/*466.44*/("""{"""),format.raw/*466.45*/("""
	       					"""),format.raw/*467.14*/("""$('#branch-alert-warning').removeClass('hidden');
			       			setTimeout(function()"""),format.raw/*468.35*/("""{"""),format.raw/*468.36*/("""
			       				"""),format.raw/*469.15*/("""$('#branch-alert-warning').addClass('hidden');
			       			"""),format.raw/*470.14*/("""}"""),format.raw/*470.15*/(""", 3000);
				       	"""),format.raw/*471.13*/("""}"""),format.raw/*471.14*/("""else if(response == 'json_expected')"""),format.raw/*471.50*/("""{"""),format.raw/*471.51*/("""
				       		"""),format.raw/*472.14*/("""$('#branch-alert-danger').removeClass('hidden');
			       			setTimeout(function()"""),format.raw/*473.35*/("""{"""),format.raw/*473.36*/("""
			       				"""),format.raw/*474.15*/("""$('#branch-alert-danger').addClass('hidden');
			       			"""),format.raw/*475.14*/("""}"""),format.raw/*475.15*/(""", 3000);
					    """),format.raw/*476.10*/("""}"""),format.raw/*476.11*/("""else"""),format.raw/*476.15*/("""{"""),format.raw/*476.16*/("""
			       			"""),format.raw/*477.14*/("""var result = response.split("||");
			       			var branchId = result[0];
			       			var branchName = result[1];
			       			$("select[name='branch']").append('<option value="' + branchId + '">' + branchName + '</option>');
			       			
			       			$('#branch-alert-success').removeClass('hidden');
			       			$("#branch-alert-success").slideDown("slow");
			       			window.setTimeout(function()"""),format.raw/*484.42*/("""{"""),format.raw/*484.43*/("""$("#branch-alert-success").slideUp("slow");"""),format.raw/*484.86*/("""}"""),format.raw/*484.87*/(""",2000);
			       			$('#frmBranch').data('bootstrapValidator').resetForm();
			       			$('#frmBranch').find('input[type="text"],textarea').val("");
			       		"""),format.raw/*487.13*/("""}"""),format.raw/*487.14*/("""
		       		"""),format.raw/*488.12*/("""}"""),format.raw/*488.13*/(""",
		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*489.62*/("""{"""),format.raw/*489.63*/("""
		            	"""),format.raw/*490.16*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*490.102*/("""{"""),format.raw/*490.103*/("""}"""),format.raw/*490.104*/(""");
		            """),format.raw/*491.15*/("""}"""),format.raw/*491.16*/("""
		       	"""),format.raw/*492.11*/("""}"""),format.raw/*492.12*/(""");
			    return false;
		    """),format.raw/*494.7*/("""}"""),format.raw/*494.8*/(""");
		"""),format.raw/*495.3*/("""}"""),format.raw/*495.4*/("""); /* end document ready */
		
	</script>

""")))}))}
  }

  def render(user:User,branchList:List[Branch],roleList:List[Role],nav:String): play.twirl.api.HtmlFormat.Appendable = apply(user,branchList,roleList,nav)

  def f:((User,List[Branch],List[Role],String) => play.twirl.api.HtmlFormat.Appendable) = (user,branchList,roleList,nav) => apply(user,branchList,roleList,nav)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:54 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/admin/user.scala.html
                  HASH: 62c4538de30bc87063b6e1e49a8dea62a84b65d7
                  MATRIX: 757->1|940->74|968->100|995->102|1044->143|1083->145|1112->148|4852->3861|4883->3883|4922->3884|4961->3896|5002->3921|5041->3922|5081->3934|5124->3950|5139->3956|5168->3964|5198->3967|5213->3973|5244->3983|5296->4004|5338->4015|5376->4025|5858->4480|5888->4500|5928->4501|5966->4511|6004->4532|6044->4533|6083->4543|6127->4559|6141->4563|6171->4571|6202->4574|6216->4578|6249->4589|6300->4608|6340->4617|6376->4625|8354->6575|8370->6581|8428->6617|10752->8913|10768->8919|10836->8965|10939->9040|10955->9046|11020->9089|11134->9175|11150->9181|11222->9231|11354->9335|11370->9341|11448->9396|11911->9830|11941->9831|11977->9839|12075->9908|12105->9909|12138->9914|12186->9934|12215->9935|12309->10000|12339->10001|12374->10008|12403->10009|12480->10057|12510->10058|12545->10065|12574->10066|12654->10117|12684->10118|12719->10125|12748->10126|12830->10179|12860->10180|12895->10187|12924->10188|13007->10242|13037->10243|13072->10250|13101->10251|13182->10303|13212->10304|13247->10311|13276->10312|13359->10366|13389->10367|13422->10372|13669->10591|13685->10597|13735->10625|13823->10684|13853->10685|13996->10799|14026->10800|14137->10882|14167->10883|14201->10889|14270->10929|14300->10930|14336->10938|14448->11022|14477->11023|14513->11031|14542->11032|14574->11036|14603->11037|14936->11341|14966->11342|14999->11347|15101->11421|15130->11422|15204->11467|15234->11468|15267->11473|15378->11556|15407->11557|15485->11606|15515->11607|15548->11612|16319->12355|16348->12356|16381->12361|16446->12397|16476->12398|16509->12403|16651->12517|16680->12518|16716->12526|16783->12564|16813->12565|16846->12570|17110->12806|17139->12807|17175->12815|17233->12844|17263->12845|17296->12850|17750->13276|17779->13277|17812->13282|17896->13337|17926->13338|17959->13343|18047->13403|18076->13404|18254->13553|18284->13554|18317->13559|18420->13634|18449->13635|18527->13684|18557->13685|18593->13693|18754->13825|18784->13826|18828->13841|18979->13963|19009->13964|19058->13984|19088->13985|19132->14000|19171->14010|19201->14011|19249->14030|19290->14042|19320->14043|19372->14066|19409->14074|19439->14075|19495->14102|19675->14253|19705->14254|19775->14295|19805->14296|19849->14311|19879->14312|19937->14341|19967->14342|20015->14361|20056->14373|20086->14374|20135->14394|20170->14400|20200->14401|20250->14422|20364->14507|20394->14508|20457->14542|20487->14543|20531->14558|20561->14559|20633->14602|20663->14603|20714->14625|20755->14637|20785->14638|20840->14664|20880->14675|20910->14676|20969->14706|21109->14817|21139->14818|21206->14856|21236->14857|21289->14881|21407->14970|21437->14971|21513->15018|21543->15019|21590->15037|21620->15038|21685->15074|21715->15075|21766->15097|21807->15109|21837->15110|21892->15136|21932->15147|21962->15148|22021->15178|22154->15282|22184->15283|22251->15321|22281->15322|22334->15346|22452->15435|22482->15436|22558->15483|22588->15484|22635->15502|22665->15503|22705->15514|22735->15515|22770->15522|22799->15523|22871->15566|22901->15567|22937->15575|23108->15717|23138->15718|23168->15719|23250->15772|23280->15773|23314->15779|23488->15924|23518->15925|23553->15932|23621->15972|23650->15973|23683->15977|23713->15978|23748->15985|23801->16010|23830->16011|23863->16016|23892->16017|23982->16078|24012->16079|24053->16091|24088->16098|24104->16104|24160->16138|24367->16316|24397->16317|24439->16330|24497->16359|24527->16360|24570->16374|24681->16456|24711->16457|24755->16472|24842->16530|24872->16531|24922->16552|24952->16553|25017->16589|25047->16590|25090->16604|25200->16685|25230->16686|25274->16701|25360->16758|25390->16759|25437->16777|25467->16778|25500->16782|25530->16783|25570->16794|25772->16967|25802->16968|25872->17009|25902->17010|26121->17200|26151->17201|26192->17213|26222->17214|26314->17277|26344->17278|26389->17294|26505->17380|26536->17381|26567->17382|26613->17399|26643->17400|26683->17411|26713->17412|26771->17442|26800->17443|26919->17533|26949->17534|26985->17542|27146->17674|27176->17675|27220->17690|27371->17812|27401->17813|27436->17820|27465->17821|27537->17864|27567->17865|27603->17873|27774->18015|27804->18016|27834->18017|27916->18070|27946->18071|27980->18077|28154->18222|28184->18223|28219->18230|28287->18270|28316->18271|28349->18275|28379->18276|28414->18283|28467->18308|28496->18309|28529->18314|28558->18315|28648->18376|28678->18377|28719->18389|28933->18574|28963->18575|29005->18588|29065->18619|29095->18620|29138->18634|29251->18718|29281->18719|29325->18734|29414->18794|29444->18795|29494->18816|29524->18817|29589->18853|29619->18854|29662->18868|29774->18951|29804->18952|29848->18967|29936->19026|29966->19027|30013->19045|30043->19046|30076->19050|30106->19051|30149->19065|30582->19469|30612->19470|30684->19513|30714->19514|30906->19677|30936->19678|30977->19690|31007->19691|31099->19754|31129->19755|31174->19771|31290->19857|31321->19858|31352->19859|31398->19876|31428->19877|31468->19888|31498->19889|31556->19919|31585->19920|31618->19925|31647->19926
                  LINES: 26->1|29->1|31->4|32->5|32->5|32->5|34->7|115->88|115->88|115->88|116->89|116->89|116->89|117->90|117->90|117->90|117->90|117->90|117->90|117->90|118->91|119->92|120->93|130->103|130->103|130->103|131->104|131->104|131->104|132->105|132->105|132->105|132->105|132->105|132->105|132->105|133->106|134->107|135->108|178->151|178->151|178->151|222->195|222->195|222->195|224->197|224->197|224->197|226->199|226->199|226->199|228->201|228->201|228->201|249->222|249->222|251->224|254->227|254->227|255->228|256->229|256->229|256->229|256->229|257->230|257->230|257->230|257->230|258->231|258->231|258->231|258->231|259->232|259->232|259->232|259->232|260->233|260->233|260->233|260->233|261->234|261->234|261->234|261->234|262->235|262->235|262->235|262->235|263->236|271->244|271->244|271->244|272->245|272->245|274->247|274->247|275->248|275->248|276->249|276->249|276->249|277->250|279->252|279->252|280->253|280->253|281->254|281->254|291->264|291->264|292->265|294->267|294->267|296->269|296->269|297->270|299->272|299->272|301->274|301->274|302->275|317->290|317->290|319->292|319->292|319->292|320->293|323->296|323->296|325->298|325->298|325->298|326->299|331->304|331->304|333->306|333->306|333->306|334->307|344->317|344->317|346->319|346->319|346->319|347->320|348->321|348->321|352->325|352->325|353->326|354->327|354->327|355->328|355->328|356->329|359->332|359->332|360->333|363->336|363->336|364->337|364->337|365->338|365->338|365->338|366->339|366->339|366->339|367->340|367->340|367->340|368->341|370->343|370->343|371->344|371->344|372->345|372->345|373->346|373->346|374->347|374->347|374->347|375->348|375->348|375->348|376->349|378->351|378->351|379->352|379->352|380->353|380->353|381->354|381->354|382->355|382->355|382->355|383->356|383->356|383->356|384->357|386->359|386->359|387->360|387->360|388->361|390->363|390->363|391->364|391->364|392->365|392->365|393->366|393->366|394->367|394->367|394->367|395->368|395->368|395->368|396->369|398->371|398->371|399->372|399->372|400->373|402->375|402->375|403->376|403->376|404->377|404->377|405->378|405->378|406->379|406->379|407->380|407->380|408->381|412->385|412->385|412->385|413->386|413->386|414->387|417->390|417->390|418->391|419->392|419->392|419->392|419->392|420->393|421->394|421->394|422->395|422->395|424->397|424->397|425->398|425->398|425->398|425->398|430->403|430->403|431->404|431->404|431->404|432->405|433->406|433->406|434->407|435->408|435->408|436->409|436->409|436->409|436->409|437->410|438->411|438->411|439->412|440->413|440->413|441->414|441->414|441->414|441->414|442->415|445->418|445->418|445->418|445->418|448->421|448->421|449->422|449->422|450->423|450->423|451->424|451->424|451->424|451->424|452->425|452->425|453->426|453->426|455->428|455->428|459->432|459->432|460->433|463->436|463->436|464->437|467->440|467->440|468->441|468->441|469->442|469->442|470->443|474->447|474->447|474->447|475->448|475->448|476->449|479->452|479->452|480->453|481->454|481->454|481->454|481->454|482->455|483->456|483->456|484->457|484->457|486->459|486->459|487->460|492->465|492->465|493->466|493->466|493->466|494->467|495->468|495->468|496->469|497->470|497->470|498->471|498->471|498->471|498->471|499->472|500->473|500->473|501->474|502->475|502->475|503->476|503->476|503->476|503->476|504->477|511->484|511->484|511->484|511->484|514->487|514->487|515->488|515->488|516->489|516->489|517->490|517->490|517->490|517->490|518->491|518->491|519->492|519->492|521->494|521->494|522->495|522->495
                  -- GENERATED --
              */
          