import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { EditComponent } from './edit/edit.component';
import { LoginComponent } from './login/login.component';
import { MycarsComponent } from './mycars/mycars.component';
import { ProductByIdComponent } from './product-by-id/product-by-id.component';
import { ProductComponent } from './product/product.component';

const routes: Routes = [
  { path:'products', component: ProductComponent},
  { path:'product', component: ProductByIdComponent},
  { path:'admin', component: AdminComponent},
  { path:'login', component: LoginComponent},
  { path:'mycars', component: MycarsComponent},
  { path:'edit', component: EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
