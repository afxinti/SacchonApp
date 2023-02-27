import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BglEditComponent } from './bgl-edit.component';

describe('BglEditComponent', () => {
  let component: BglEditComponent;
  let fixture: ComponentFixture<BglEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BglEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BglEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
