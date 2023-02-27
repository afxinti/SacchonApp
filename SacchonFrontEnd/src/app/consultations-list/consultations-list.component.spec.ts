import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultationsListComponent } from './consultations-list.component';

describe('ConsultationsListComponent', () => {
  let component: ConsultationsListComponent;
  let fixture: ComponentFixture<ConsultationsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultationsListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultationsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
