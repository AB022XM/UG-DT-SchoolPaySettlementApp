import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'school',
        data: { pageTitle: 'schoolPaySettlementApp.school.home.title' },
        loadChildren: () => import('./school/school.module').then(m => m.SchoolModule),
      },
      {
        path: 'notify-transaction',
        data: { pageTitle: 'schoolPaySettlementApp.notifyTransaction.home.title' },
        loadChildren: () => import('./notify-transaction/notify-transaction.module').then(m => m.NotifyTransactionModule),
      },
      {
        path: 'partner',
        data: { pageTitle: 'schoolPaySettlementApp.partner.home.title' },
        loadChildren: () => import('./partner/partner.module').then(m => m.PartnerModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
