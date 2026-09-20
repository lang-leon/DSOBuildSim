import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuffSelector } from './buff-selector';

describe('BuffSelector', () => {
  let component: BuffSelector;
  let fixture: ComponentFixture<BuffSelector>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuffSelector],
    }).compileComponents();

    fixture = TestBed.createComponent(BuffSelector);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
