import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticsDciComponent } from './statistics-dci.component';

describe('StatisticsDciComponent', () => {
  let component: StatisticsDciComponent;
  let fixture: ComponentFixture<StatisticsDciComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatisticsDciComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatisticsDciComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
