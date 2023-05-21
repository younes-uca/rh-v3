import {Component, OnInit} from '@angular/core';
import {PointageService} from 'src/app/controller/service/Pointage.service';
import {PointageDto} from 'src/app/controller/model/Pointage.model';
import {PointageCriteria} from 'src/app/controller/criteria/PointageCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { EmployeeService } from 'src/app/controller/service/Employee.service';

import {EmployeeDto} from 'src/app/controller/model/Employee.model';


@Component({
  selector: 'app-pointage-list-admin',
  templateUrl: './pointage-list-admin.component.html'
})
export class PointageListAdminComponent extends AbstractListController<PointageDto, PointageCriteria, PointageService>  implements OnInit {

    fileName = 'Pointage';

    employees :Array<EmployeeDto>;
  
    constructor(pointageService: PointageService, private employeeService: EmployeeService) {
        super(pointageService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadEmployee();
    }

    public async loadPointages(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Pointage', 'list');
        isPermistted ? this.service.findAll().subscribe(pointages => this.items = pointages,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'heureArrive', header: 'Heure arrive'},
            {field: 'heureSortie', header: 'Heure sortie'},
            {field: 'tempsRetard', header: 'Temps retard'},
            {field: 'employee?.code', header: 'Employee'},
        ];
    }


    public async loadEmployee(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Pointage', 'list');
        isPermistted ? this.employeeService.findAllOptimized().subscribe(employees => this.employees = employees,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PointageDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                'Heure arrive': this.datePipe.transform(e.heureArrive , 'dd/MM/yyyy hh:mm'),
                'Heure sortie': this.datePipe.transform(e.heureSortie , 'dd/MM/yyyy hh:mm'),
                 'Temps retard': e.tempsRetard ,
                'Employee': e.employee?.code ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Heure arrive Min': this.criteria.heureArriveFrom ? this.datePipe.transform(this.criteria.heureArriveFrom , this.dateFormat) : environment.emptyForExport ,
            'Heure arrive Max': this.criteria.heureArriveTo ? this.datePipe.transform(this.criteria.heureArriveTo , this.dateFormat) : environment.emptyForExport ,
            'Heure sortie Min': this.criteria.heureSortieFrom ? this.datePipe.transform(this.criteria.heureSortieFrom , this.dateFormat) : environment.emptyForExport ,
            'Heure sortie Max': this.criteria.heureSortieTo ? this.datePipe.transform(this.criteria.heureSortieTo , this.dateFormat) : environment.emptyForExport ,
            'Temps retard Min': this.criteria.tempsRetardMin ? this.criteria.tempsRetardMin : environment.emptyForExport ,
            'Temps retard Max': this.criteria.tempsRetardMax ? this.criteria.tempsRetardMax : environment.emptyForExport ,
        //'Employee': this.criteria.employee?.code ? this.criteria.employee?.code : environment.emptyForExport ,
        }];
      }
}
